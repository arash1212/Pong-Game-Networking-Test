package com.salehi.pong.entity;

import com.salehi.pong.MainPanel;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

public class Ball implements GameObject {
    private int x = 50, y, width, height;
    private int ya = 5, xa = 5;
    private int speed = 6;
    private JFrame frame;
    private Shape shape;
    private Rectangle collision;
    private MainPanel mainPanel;

    public int getX() {
        return x;
    }

    public Ball setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Ball setY(int y) {
        this.y = y;
        return this;
    }

    public int getYa() {
        return ya;
    }

    public Ball setYa(int ya) {
        this.ya = ya;
        return this;
    }

    public int getXa() {
        return xa;
    }

    public Ball setXa(int xa) {
        this.xa = xa;
        return this;
    }

    public Ball(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.frame = mainPanel.getFrame();
        x = 50;
        y = 0;
        width = 20;
        height = 20;
        //
        collision = new Rectangle(x, y, width, height);
    }

    public void move() {
        if (y <= 0) {
            ya = speed;
        } else if (y > frame.getHeight() - 65) {
            ya = -speed;
        }
        //
        if (x <= 0) {
            System.out.println("player 1 lost");
            mainPanel.setPlayer1Score(mainPanel.getPlayer1Score() - 1);
//            System.exit(0);
            xa = speed;
        } else if (x > frame.getWidth() - 65) {
            xa = -speed;
        }
        y = ((int) (y + Math.random())) + ya;
        x = x + xa;
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(x, y, width, height);
        collision.setLocation(x, y);
//        graphics2D.draw(collision);
    }

    @Override
    public Rectangle getCollision() {
        return collision;
    }


}
