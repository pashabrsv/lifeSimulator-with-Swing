package com.company;

import java.util.ArrayList;

public class Cell {                            //Класс ячейки
    ArrayList<Cell> near;                    //список рядомнаходящихся ячеек
    CellState cellState;

    public Cell(){                              // Конструктор ячейки
        cellState = CellState.NONE;
        near = new ArrayList<>();              //не забываем создать пустрой список
    }

    void addNear(Cell cell){                    //Добавляем соседей ячейки
        near.add(cell);
    }   //добавляем всех соседей

    void step1(){
        int around = countNearCell();                  //посчитаем сколько же клеток вокруг
        cellState = cellState.step1(around);
    }

    void step2(){
        cellState = cellState.step2();
    }
    int countNearCell(){                     //Метод проверяет сколько существ вокруг ячейки
        int count;
        count = 0;
        for (Cell cell : near)
            if (cell.cellState.isCell())          //Если есть ячейка -> увелич. на 1 и возвращаем
                count++;
        return count;
    }
}
