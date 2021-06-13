package com.salehi.pong;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //Panel
        MainPanel mainPanel = new MainPanel(jFrame);
        jFrame.add(mainPanel);
        jFrame.addKeyListener(mainPanel);
        //

        jFrame.setBounds(0, 0, 700, 600);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
