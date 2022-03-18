package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable{

    JFrame frame;
    Box[][] boxes;                 //Массив хранения боксов

    @Override
    public void run(){
        initFrame();
        initBoxes();
        initTimer();
    }



    void initFrame(){
        frame = new JFrame();
        frame.getContentPane() .setLayout(null);
        frame.setSize(Config.SIZE*Config.WIDTH +25, Config.SIZE*Config.HEIGHT +45);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life Simulator");
    }

    void initBoxes(){
        boxes = new Box [Config.WIDTH] [Config.HEIGHT];     //Метод создания боксов с константами размеров

        for (int x = 0; x < Config.WIDTH; x++){               //Создаём клетки
            for (int y = 0; y < Config.HEIGHT; y++){
                boxes[x][y] = new Box(x, y);                   //Непосредственно созд. бокс в координатах
                frame.add(boxes[x][y]);                       //Добавляем бокс на фрейм для видимости
            }

        for (x = 0; x < Config.WIDTH; x++)              //Выбираем конкретную клетку
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx <= 1; sx++)                ////Проверяем все 8 клеток...
                    for (int sy = -1; sy <= 1; sy++)
                        if (!(sx == 0) & (sy == 0)) {
                            boxes[x][y].cell.addNear(boxes                //добавляем рядомстоящих как соседа
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
                        }
        ////...а девятая, центральная отсеивается
        for (x = 10; x < 15; x++){
            boxes[x][10].cell.cellState = CellState.LIFE;
            boxes[x][10].setColor();
        }
    }
}
    private void initTimer(){
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener{
        boolean flop = false;                                 //Переменная, переключающаяся либо на step1, либо на step2
        public void actionPerformed(ActionEvent e){
            flop = !flop;
            for(int x = 0; x < Config.WIDTH; x++){
                for (int y = 0; y < Config.HEIGHT; y++){
                   if (flop)
                       boxes[x][y].step1();
                    else
                        boxes[x][y].step2();
                }
            }
        }
    }
}