package com.company;

import java.awt.*;

public class Config {
    public static final int SIZE = 20;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 30;
    public static final int SLEEPMS = 500;

    public static Color getColor (CellState cellState){

        return switch (cellState) {
            case NONE -> Color.GREEN;
            case BORN -> Color.YELLOW;
            case LIFE -> Color.RED;
            case DEAD -> Color.BLUE;
        };

    }
}
