package com.salehi.pong;

import com.salehi.pong.entity.Ball;
import com.salehi.pong.entity.GameObject;
import com.salehi.pong.entity.Player;
import com.salehi.pong.entity.Player2AI;
import javafx.scene.input.KeyCode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends JPanel implements KeyListener, Runnable {

    private Thread thread;
    private Player player;
    private Player2AI player2AI;
    private Ball ball;
    private JFrame frame;
    private List<GameObject> gameObjects = new ArrayList<>();
    //
    private int player1Score;
    private int player2Score;
    //
    private BufferedImage backGroundImage;

    public int getPlayer2Score() {
        return player2Score;
    }

    public MainPanel setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
        return this;
    }

    public JFrame getFrame() {
        return frame;
    }

    public MainPanel setFrame(JFrame frame) {
        this.frame = frame;
        return this;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public MainPanel setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
        return this;
    }

    public MainPanel(JFrame frame) {
        this.frame = frame;

        ball = new Ball(this);
        player = new Player(frame);
        player2AI = new Player2AI(frame);
        player.setGameObjects(gameObjects);
        player2AI.setGameObjects(gameObjects);
        //
        gameObjects.add(ball);
        gameObjects.add(player);
        gameObjects.add(player2AI);
        //
        try{
            backGroundImage= ImageIO.read(new File("out\\production\\Graphics_test\\com\\salehi\\pong\\Assets\\background2.jpg"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error in finding background image");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backGroundImage,0,0,this);
        //
        Graphics2D graphics2D = (Graphics2D) g;
        this.setBackground(Color.BLACK);
        //Player
        for (GameObject gameObject : gameObjects) {
            gameObject.paint(graphics2D);
        }
        //
        graphics2D.drawString(String.valueOf(player1Score) + " - ", frame.getWidth() / 2, 50);
        graphics2D.drawString(String.valueOf(player2Score), frame.getWidth() / 2 + 16, 50);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            player.move();
            player2AI.move();
            ball.move();
            repaint();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player.setYa(-9);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.setYa(9);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player.setYa(0);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.setYa(0);
        }
    }
}
