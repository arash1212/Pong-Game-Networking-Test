package com.salehi.pong.entity;

import java.awt.*;

public interface GameObject {
    void paint(Graphics graphics);
    Rectangle getCollision();
}
