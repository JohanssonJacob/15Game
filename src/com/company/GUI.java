package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
        slidePanel.setLayout(new GridLayout(4,4));
        
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
        resetButton.addActionListener(this);


        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
    }


}
