package com.nishant.algorithms.NeuralNetworks;

import javax.swing.*;
import java.awt.*;

public class MNISTTrainer extends JPanel {
    public MNISTTrainer() {
        JFrame frame = new JFrame("Testing single perceptrons");
        frame.setBounds(100, 100, WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.add(this);
        frame.setVisible(true);
    }
}
