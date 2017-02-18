package ru.ivhmao;

import java.awt.*;
import java.util.ArrayList;

import static ru.ivhmao.Constants.*;

/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class Snake {
    public ArrayList<Segment> segments;
    public int direction = RIGHT;
    public int speed = 800;
    private SnakeGame snakeGame;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isFood(Food f) {
        return f.getX() == segments.get(0).getX() && f.getY() == segments.get(0).getY();
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    Snake(SnakeGame sg){
        snakeGame = sg;
        segments = new ArrayList<Segment>();
    }

    public void init(){
        direction = RIGHT;
        speed = 800;
        segments.clear();
        for (int i = 0; i < INITSIZE; i++) {
            segments.add(new Segment(INITX - i, INITY));
        }
    }

    public void paint(Graphics g) {
        for (Segment segment : segments) {
            segment.paint(g);
        }
    }

    public void move() {
        int x = segments.get(0).getX();
        int y = segments.get(0).getY();

        switch (direction) {
            case UP:
                y--;
                if (y < 0) y = COUNTY - 1;
                break;
            case DOWN:
                y++;
                if (y >= COUNTY) y = 0;
                break;
            case LEFT:
                x--;
                if (x < 0) x = COUNTX - 1;
                break;
            case RIGHT:
                x++;
                if (x >= COUNTX) x = 0;
                break;
        }

        for (Segment s : segments) {
            if (s.getX() == x && s.getY() == y) gameOver = true;
        }

        segments.add(0, new Segment(x, y));
        boolean res=false;
        for (Food food:snakeGame.foods) {
            if(isFood(food))res=true;
        }

        if (!res)
            segments.remove(segments.size() - 1);

        if((segments.size()-INITSIZE) >=100) {setSpeed(50);}
        else if ((segments.size()-INITSIZE) >=90) {setSpeed(90);}
        else if ((segments.size()-INITSIZE) >=80) {setSpeed(100);}
        else if ((segments.size()-INITSIZE) >=50) {setSpeed(150);}
        else if ((segments.size()-INITSIZE) >=40) {setSpeed(200);}
        else if ((segments.size()-INITSIZE) >=30) {setSpeed(200);}
        else if ((segments.size()-INITSIZE) >=20) {setSpeed(300);}
        else if ((segments.size()-INITSIZE) >=10) {setSpeed(400);}
        else speed=800;
    }

    public boolean isSnake(int x, int y) {
        boolean answer = false;
        for (Segment s : segments) {
            if (s.getX() == x && s.getY() == y) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public int getDirection() {
        return direction;
    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> segments) {
        this.segments = segments;
    }

}
