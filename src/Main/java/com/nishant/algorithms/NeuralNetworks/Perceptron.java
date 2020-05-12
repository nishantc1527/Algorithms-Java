package com.nishant.algorithms.NeuralNetworks;

import java.util.Arrays;

public class Perceptron {
    private double[] weights;
    private double learningRate;

    public Perceptron() {
        weights = new double[2];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() * 2 - 1;
        }
        learningRate = 0.4;

        System.out.println(Arrays.toString(weights));
    }

    public int guess(double[] inputs) {
        double sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
        }

        return ((int) activate(sum));
    }

    private double activate(double n) {
        return n > 0 ? 1 : -1;
    }

    public void train(double[] inputs, int target) {
        int guess = guess(inputs);
        double error = target - guess;

        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * inputs[i] * learningRate;
        }
    }
}
