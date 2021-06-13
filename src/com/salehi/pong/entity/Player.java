package com.salehi.pong.entity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Player implements GameObject {
    private int x = 20, y = 0, width, height;
    private int ya;
    Rectangle player;
    Rectangle collision;
    private JFrame jFrame;
    private List<GameObject> gameObjects;

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Player setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
        return this;
    }

    public Player(JFrame frame) {
        this.jFrame = frame;
        //
        width = 10;
        height = 100;
        ya = 0;
        collision = new Rectangle(x, y, width, height);
        player = new Rectangle(x, y, width, height);
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        player.setLocation(x, y);
        collision.setLocation(x, y);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fill(player);
        //
//        graphics2D.draw(collision);

    }

    @Override
    public Rectangle getCollision() {
        return collision;
    }


    public void move() {
        if (ya > 0 && y + ya < jFrame.getHeight() - (player.height + 38)) {
            y = y + (ya);
        } else if (ya < 0 && y - ya > 0) {
            y = y + (ya);
        }
        collision();
    }

    public int getYa() {
        return ya;
    }

    public Player setYa(int ya) {
        this.ya = ya;
        return this;
    }

    public void collision() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getCollision() != this.collision && collision.intersects(gameObject.getCollision())) {
//                System.out.println("hit");
            }
            if (collision.intersects(gameObject.getCollision())&&gameObject instanceof Ball) {
                ((Ball)gameObject).setYa(-(((Ball) gameObject).getYa())).setXa(5);
            }
        }
    }

}
