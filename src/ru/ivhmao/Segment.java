package ru.ivhmao;

import java.awt.*;
import static ru.ivhmao.Constants.*;
/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class Segment {
    int x;
    int y;

    Segment() {
        x = -1;
        y = -1;
    }

    public Segment(int xi, int yi) {
        x = xi;
        y = yi;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(SIZEONEFIELD * x, SIZEONEFIELD * y, SIZEONEFIELD, SIZEONEFIELD);
    }
}
