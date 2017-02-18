package ru.ivhmao;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static ru.ivhmao.Constants.*;
/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class Food extends Segment {
    SnakeGame snakeGame;
    Food(SnakeGame sg) {
        super(-1,-1);
        snakeGame = sg;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(SIZEONEFIELD * x, SIZEONEFIELD * y, SIZEONEFIELD, SIZEONEFIELD);
    }

    public void newPlace(){
        super.setX(ThreadLocalRandom.current().nextInt(0,COUNTX));
        super.setY(ThreadLocalRandom.current().nextInt(0,COUNTY));
        while (snakeGame.snake.isSnake(super.getX(),super.getY())){
            super.setX(ThreadLocalRandom.current().nextInt(0,COUNTX));
            super.setY(ThreadLocalRandom.current().nextInt(0,COUNTY));
        }


    }

}