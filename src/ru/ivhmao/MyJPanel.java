package ru.ivhmao;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static ru.ivhmao.Constants.*;

/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class MyJPanel extends JPanel {
    Snake snake;
    //Food food;
    ArrayList<Food> foods;
    MyJPanel(SnakeGame sg){
        super();
        snake = sg.snake;
        foods = sg.foods;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, SIZEONEFIELD * COUNTX - 1, SIZEONEFIELD * COUNTY - 1);

        g.setColor(Color.blue);
        g.drawRect(0, 0, SIZEONEFIELD * COUNTX - 1, SIZEONEFIELD * COUNTY - 1);

        for (Food food:foods) {
            food.paint(g);
        }
        snake.paint(g);


    }
}
