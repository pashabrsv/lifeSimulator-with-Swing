package com.company;

import javax.swing.*;

public class Box extends JPanel {                          //Создание ячейки(организма)

    Cell cell;                                             //Тут будем хранить саму ячейку(описываем)

    public Box (int x, int y){                         //конструктор класса
        super();
        cell = new Cell();
        setBounds(x* Config.SIZE, y* Config.SIZE, Config.SIZE, Config.SIZE);
        setBackground(Config.getColor(CellState.NONE));
    }

    public void initCells(int x, int y){
    }
    public void setColor(){
        setBackground(Config.getColor(cell.cellState));
    }

    void step1(){
        setColor();
    }

    void step2(){
        setColor();
    }
}
