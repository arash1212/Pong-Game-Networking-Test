package com.salehi.pong;

import java.awt.*;
import java.util.List;

public class Physics {

    private static final Physics instance = new Physics();

    private Physics(){

    }

    public static Physics getInstance() {
        return instance;
    }

    public static void text(Shape thiss , List<Shape> others){
        for(Shape shape : others){
            System.out.println("hit");
        }
    }
}
