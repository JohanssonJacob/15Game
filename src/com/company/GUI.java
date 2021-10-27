package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI extends JFrame implements ActionListener {

    JButton resetButton = new JButton("Reset");
    JPanel slidePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JButton[] buttons = new JButton[16];
    String blankButton = " ";


    public GUI() {
        setTitle("15-spel");
        add(slidePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        slidePanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.add(resetButton);
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setBorder(new LineBorder(Color.DARK_GRAY));
        resetButton.setPreferredSize(new Dimension(100,50));
        slidePanel.setPreferredSize(new Dimension(400,400));
        slidePanel.setLayout(new GridLayout(4,4));

        addButtons();
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
        resetButton.addActionListener(this);


        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        randomize();


    }

    public void addButtons() {
        for (int i = 0; i < buttons.length; i++) {
            if (i != 15) {
                buttons[i] = new JButton("" +(i + 1));
                buttons[i].setBackground(Color.LIGHT_GRAY);
                buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
                buttons[i].setBorder(new LineBorder(Color.DARK_GRAY));
                buttons[i].setVisible(true);
            } else {
                buttons[15] = new JButton(blankButton);
                buttons[15].setBackground(Color.LIGHT_GRAY);
                buttons[15].setFont(new Font("Arial", Font.BOLD, 50));
                buttons[15].setBorder(new LineBorder(Color.DARK_GRAY));
                buttons[15].setVisible(false);
            }


        }
        for (JButton button : buttons) {
            slidePanel.add(button);
        }
    }
    public void randomize() {
        Random r = new Random();
        int[] tileNumbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for (int i = 0; i < tileNumbers.length; i++) {
            int randomIndexToSwap = r.nextInt(tileNumbers.length);
            int temp = tileNumbers[randomIndexToSwap];
            tileNumbers[randomIndexToSwap] = tileNumbers[i];
            tileNumbers[i] = temp;
        }
        for (int i = 0; i < tileNumbers.length; i++) {
            buttons[i].setText(String.valueOf(tileNumbers[i]));
            buttons[i].setBackground(Color.LIGHT_GRAY);
        }
        buttons[15].setText(blankButton);
        buttons[15].setVisible(false);

    }

    public void swapButtons(int clickedButtonIndex, int blankButtonIndex) {
        buttons[blankButtonIndex].setText(buttons[clickedButtonIndex].getText());
        buttons[blankButtonIndex].setVisible(true);
        buttons[clickedButtonIndex].setText(blankButton);
        buttons[clickedButtonIndex].setBackground(Color.white);
        buttons[blankButtonIndex].setBackground(Color.LIGHT_GRAY);
    }

    public void gameHandler(int clickedButtonIndex, int checkPos1, int checkPos2, int checkPos3, int checkPos4) {
        int blankButtonIndex = 100;
        int indexToSwap = 100;

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals(blankButton)) {
                blankButtonIndex = i;
            }
        }
        if (checkPos1 == blankButtonIndex) {
            indexToSwap = checkPos1;
        } else if (checkPos2 == blankButtonIndex) {
            indexToSwap = checkPos2;
        } else if (checkPos3 != 100) {
            if (checkPos3 == blankButtonIndex) {
                indexToSwap = checkPos3;
            } else if (checkPos4 != 100) {
                if (checkPos4 == blankButtonIndex) {
                    indexToSwap = checkPos4;
                }
            }
        }
        if (indexToSwap != 100) {
            swapButtons(clickedButtonIndex, indexToSwap);
        }
        if (isSolved()) {
            gameWon();
        }
    }
    public boolean isSolved() {
        String solved = "123456789101112131415 ";
        StringBuilder s = new StringBuilder();
        for (JButton button : buttons) {
            s.append(button.getText());
        }
        return solved.equals(s.toString());
    }
    public void gameWon() {
        JOptionPane.showMessageDialog(this, "Du vann!");
        randomize();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        int notUsed = 100;
        if (e.getSource() == resetButton) {
            randomize();
        } else if (e.getSource() == buttons[0]) {
            gameHandler(0, 1, 4, notUsed, notUsed);
        } else if (e.getSource() == buttons[1]) {
            gameHandler(1, 2, 5 ,0, notUsed);
        } else if (e.getSource() == buttons[2]) {
            gameHandler(2, 3, 6, 1, notUsed);
        } else if (e.getSource() == buttons[3]) {
            gameHandler(3, 7, 2, notUsed, notUsed);
        } else if (e.getSource() == buttons[4]) {
            gameHandler(4, 8, 5, 0, notUsed);
        } else if (e.getSource() == buttons[5]) {
            gameHandler(5, 9, 6, 1, 4);
        } else if (e.getSource() == buttons[6]) {
            gameHandler(6, 10, 7, 2, 5);
        } else if (e.getSource() == buttons[7]) {
            gameHandler(7, 11, 6, 3, notUsed);
        } else if (e.getSource() == buttons[8]) {
            gameHandler(8, 12, 9, 4, notUsed);
        } else if (e.getSource() == buttons[9]) {
            gameHandler(9, 13, 10, 5, 8);
        } else if (e.getSource() == buttons[10]) {
            gameHandler(10, 14, 11, 6 ,9);
        } else if (e.getSource() == buttons[11]) {
            gameHandler(11, 15, 10 ,7, notUsed);
        } else if (e.getSource() == buttons[12]) {
            gameHandler(12, 13, 8, notUsed, notUsed);
        } else if (e.getSource() == buttons[13]) {
            gameHandler(13, 14, 9, 12, notUsed);
        } else if (e.getSource() == buttons[14]) {
            gameHandler(14, 15, 10, 13, notUsed);
        } else if (e.getSource() == buttons[15]) {
            gameHandler(15, 14, 11, notUsed, notUsed);
        }


    }


}
