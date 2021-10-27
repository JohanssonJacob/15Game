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
                buttons[15].setVisible(false);
            }


        }
        for (JButton button : buttons) {
            slidePanel.add(button);
        }
    }
    public void randomize() {
        Random r = new Random();
        int[] tileNumbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        for (int i = 0; i < tileNumbers.length; i++) {
            int randomIndexToSwap = r.nextInt(tileNumbers.length);
            int temp = tileNumbers[randomIndexToSwap];
            tileNumbers[randomIndexToSwap] = tileNumbers[i];
            tileNumbers[i] = temp;
        }
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(String.valueOf(tileNumbers[i]));
        }

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());

        if (e.getSource() == resetButton) {
            randomize();
        }

    }


}
