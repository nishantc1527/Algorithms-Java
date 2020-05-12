package com.nishant.algorithms.NeuralNetworks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class XORVisualizer extends JPanel {
    private OneHiddenLayerNeuralNetwork nn;
    private static final int WIDTH = 900, HEIGHT = 900;

    public XORVisualizer() {
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double input1, input2;
        for (int i = 0; i < 40; i++) {
            input1 = Math.random() < 0.5 ? 0 : 1;
            input2 = Math.random() < 0.5 ? 0 : 1;
//        input1 = Math.random();
//        input2 = Math.random();
            nn.train(new double[]{input1, input2}, new double[]{Math.abs(input1 - input2)});
        }

        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        double guess;
        Color grayscale;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                guess = nn.predict(new double[]{((double) i) / WIDTH, ((double) j) / HEIGHT})[0];
                grayscale = new Color((int) (guess * 255), (int) (guess * 255), (int) (guess * 255));
                img.setRGB(i, j, grayscale.getRGB());
            }
        }

        g.drawImage(img, 0, 0, null);
    }

    public static void main(String[] args) {
        XORVisualizer v = new XORVisualizer();

        v.nn = new OneHiddenLayerNeuralNetwork(2, 10, 1);
//        double input1, input2;
//        for (int i = 0; i < 2000000; i++) {
//            if (i % 2 != 0) continue;
//            input1 = Math.random() < 0.5 ? 0 : 1;
//            input2 = Math.random() < 0.5 ? 0 : 1;
//            input1 = Math.random();
//            input2 = Math.random();
//            v.nn.train(new double[]{input1, input2}, new double[]{Math.abs(input1 - input2)});
//        }
        System.out.println(Arrays.toString(v.nn.predict(new double[]{0, 0})));
        System.out.println(Arrays.toString(v.nn.predict(new double[]{1, 1})));
        System.out.println(Arrays.toString(v.nn.predict(new double[]{0, 1})));
        System.out.println(Arrays.toString(v.nn.predict(new double[]{1, 0})));
        System.out.println("Done training");

        while (true) {
            v.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
