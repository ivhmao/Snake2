package ru.ivhmao;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


import static ru.ivhmao.Constants.*;

/**
 * Created by ivhmao(Maxa) on 18.02.2017.
 */
public class GUIgame implements  KeyListener, ActionListener{
    JFrame appForm;
    MyJPanel playField;
    JPanel statusField;
    JLabel myLabel;
    JButton restartButton;
    SnakeGame snakeGame;

    GUIgame(SnakeGame sg) {
        snakeGame = sg;
        appForm = new JFrame(TITLE);
        appForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appForm.setSize(SIZEONEFIELD * COUNTX, SIZEONEFIELD * COUNTY);
        appForm.setLocationRelativeTo(null);

        playField = new MyJPanel(snakeGame);
        playField.setFocusable(true);
        playField.setPreferredSize(new Dimension(SIZEONEFIELD*COUNTX,SIZEONEFIELD*COUNTY));
        playField.addKeyListener(this);
        appForm.add(playField, BorderLayout.CENTER);

        statusField = new JPanel();
        statusField.setLayout(new BorderLayout());
        statusField.setPreferredSize( new Dimension(SIZEONEFIELD*COUNTX,20));
        statusField.setBackground(Color.ORANGE);

        JPanel leftPanel = new JPanel();
        leftPanel.add(new JLabel("Очки: "));
        myLabel = new JLabel();
        leftPanel.add(myLabel);

        JPanel centerPanel = new JPanel();
        statusField.add(leftPanel, BorderLayout.WEST);
        statusField.add(centerPanel, BorderLayout.CENTER);

        restartButton = new JButton("Играть");
        //  restartButton.setEnabled(false);
        restartButton.setActionCommand("restartGame");
        restartButton.addActionListener(this);
        statusField.add(restartButton, BorderLayout.EAST);
        appForm.add(statusField, BorderLayout.NORTH);

        appForm.pack();
        appForm.setVisible(true);
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     */
    public void keyPressed(KeyEvent e) {
        if (Math.abs(snakeGame.snake.getDirection()-e.getKeyCode())!=2)
            snakeGame.snake.setDirection(e.getKeyCode());
       // super.keyPressed(e);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     */
    public void keyTyped(KeyEvent e){
        //super.keyTyped(e);
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     */
    public void keyReleased(KeyEvent e){
        //super.keyReleased(e);
    }

    public void actionPerformed(ActionEvent e){
        if ("restartGame".equals(e.getActionCommand())) {
            restartButton.setEnabled(false);
            snakeGame.start();
        }
    }

}

