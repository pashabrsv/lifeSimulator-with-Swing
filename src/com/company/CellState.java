package com.company;

public enum CellState {                                            //Перечисляем варианты состояния клетки
    NONE,   //1й шаг(поколение) - либо пусто
    BORN,   //2й шаг(поколение) - либо рождается
    LIFE,   //1й шаг(поколение) - либо живёт
    DEAD;   //2й шаг(поколение) - либо умирает

    public CellState step1(int around){                             //1 шаг(поколение) - условие зарождения или смерти
        return switch (this) {
            case NONE -> (around == 3) ? BORN : NONE;                 //Вокруг три? - зарождение
            case LIFE -> (around <= 1 || around >=4 ) ? DEAD : LIFE;            //Меньше 3 - смерть, больше - смерть.
            default -> this;
        };
    }


    public  CellState step2(){                                      //2 шаг(gen.) - логически упрощаем условия
        return switch (this) {
            case BORN -> LIFE;                 //Коль родился - живой
            case DEAD -> NONE;                 //Коль погиб - нет никого
            default -> this;
        };
    }
    public boolean isCell(){                    //Метод проверяет состояние ячейки
        return this == LIFE || this == DEAD;
    }
}
