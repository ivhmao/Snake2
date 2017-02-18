package ru.ivhmao;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static ru.ivhmao.Constants.*;
/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class SnakeGame implements Runnable{
    GUIgame guigame;
    Snake snake;
   // Food food;
    ArrayList<Food> foods;


    public static void main(String[] args){
        new SnakeGame();
    }

    SnakeGame(){
        snake = new Snake(this);
        //food = new Food(this);
        foods = new ArrayList<Food>();
        for (int i=0; i<COUNT_FOODS; i++){
            foods.add(new Food(this));
        }
        //snake.init();
        //food.newPlace();
        guigame = new GUIgame(this);
    }

    public void start(){
        gameOver = false;
        snake.init();
        //food.newPlace();

        for (int i=0; i<foods.size();i++){
            foods.get(i).newPlace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!gameOver){
            snake.move();
            if (gameOver){
                guigame.myLabel.setText(String.valueOf(snake.segments.size()-INITSIZE)+" Конец игры!!!");
                guigame.restartButton.setEnabled(true);
            }

            for (Food food : foods) {
                if (snake.isFood(food)) {
                    guigame.myLabel.setText(String.valueOf(snake.segments.size() - INITSIZE));
                    food.newPlace();
                }
            }
            guigame.playField.repaint();

            try {
                Thread.sleep(snake.getSpeed() );
               // guigame.myLabel.setText(String.valueOf(snake.segments.size()-INITSIZE)+" "+String.valueOf(snake.getSpeed()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
