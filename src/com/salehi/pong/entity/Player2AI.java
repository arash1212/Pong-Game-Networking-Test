package com.salehi.pong.entity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Player2AI implements GameObject {

    private int x = 650, y = 0, width, height;
    private int ya = 6;
    Rectangle player;
    Rectangle collision;
    private JFrame jFrame;
    private java.util.List<GameObject> gameObjects;

    public java.util.List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Player2AI setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
        return this;
    }

    public Player2AI(JFrame frame) {
        this.jFrame = frame;
        //
        width = 10;
        height = 100;
        ya = 6;
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
        graphics2D.draw(collision);

    }

    @Override
    public Rectangle getCollision() {
        return collision;
    }


    public void move() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject instanceof Ball) {
                if (((Ball) gameObject).getY() - 40 > this.y) {
                    this.y = y + ya;
                } else if (((Ball) gameObject).getY() - 40 < this.y) {
                    {
                        this.y = y - ya;
                    }
                }
            }
        }
        collision();
    }

    public int getYa() {
        return ya;
    }

    public Player2AI setYa(int ya) {
        this.ya = ya;
        return this;
    }

    public void collision() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getCollision() != this.collision && collision.intersects(gameObject.getCollision())) {
                System.out.println("hit");
            }
            if (collision.intersects(gameObject.getCollision()) && gameObject instanceof Ball) {
                ((Ball) gameObject).setYa(-(((Ball) gameObject).getYa())).setXa(-5);
            }
        }
    }
}
