package com.nishant.algorithms.neuralnetworks;

import org.jblas.DoubleMatrix;

import java.util.function.Function;

/**
 * You need jblas library installed to run this.
 * @see <a href="http://jblas.org/">http://jblas.org/</a>
 */

public class EfficientNeuralNetwork {
    private org.jblas.DoubleMatrix[] weights;
    private org.jblas.DoubleMatrix[] biases;
    private double learningRate;
    private Function<Double, Double> activation, dactivation;

    public EfficientNeuralNetwork(int inputs, int outputs, double learningRate, int... hiddenLayers) {
        if (hiddenLayers.length < 1) throw new RuntimeException("Cannot have 0 hidden layers!");
        this.learningRate = learningRate;

        weights = new org.jblas.DoubleMatrix[hiddenLayers.length + 1];
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) weights[i] = org.jblas.DoubleMatrix.rand(hiddenLayers[i], inputs);
            else if (i == weights.length - 1) weights[i] = org.jblas.DoubleMatrix.rand(outputs, hiddenLayers[i - 1]);
            else weights[i] = org.jblas.DoubleMatrix.rand(hiddenLayers[i], hiddenLayers[i - 1]);
        }
        biases = new org.jblas.DoubleMatrix[hiddenLayers.length + 1];
        for (int i = 0; i < biases.length; i++) {
            if (i == biases.length - 1) biases[i] = org.jblas.DoubleMatrix.rand(outputs, 1);
            else biases[i] = org.jblas.DoubleMatrix.rand(hiddenLayers[i], 1);
        }

        activation = (x) -> 1 / (1 + Math.exp(-x));
        dactivation = (x) -> x * (1 - x);

    }

    public double[] predict(double[] inputArr) {
        org.jblas.DoubleMatrix previous = new org.jblas.DoubleMatrix(inputArr);

        for (int i = 0; i < weights.length; i++) {
            previous = feedForward(previous, weights[i], biases[i]);
        }

        return previous.toArray();
    }

    private org.jblas.DoubleMatrix feedForward(org.jblas.DoubleMatrix inputs, org.jblas.DoubleMatrix weights, org.jblas.DoubleMatrix biases) {
        org.jblas.DoubleMatrix res = weights.mmul(inputs);
        res = res.add(biases);
        for (int i = 0; i < res.data.length; i++) {
            res.data[i] = activation.apply(res.data[i]);
        }

        return res;
    }

    public void train(double[] inputArr, double[] targetArr) {
        org.jblas.DoubleMatrix inputs = new DoubleMatrix(inputArr), targets = new DoubleMatrix(targetArr);

        org.jblas.DoubleMatrix[] actual = new org.jblas.DoubleMatrix[weights.length];
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) actual[i] = feedForward(inputs, weights[i], biases[i]);
            else actual[i] = feedForward(actual[i - 1], weights[i], biases[i]);
        }

        org.jblas.DoubleMatrix[] errors = new org.jblas.DoubleMatrix[weights.length];
        for (int i = errors.length - 1; i >= 0; i--) {
            if (i == errors.length - 1) errors[i] = targets.sub(actual[i]);
            else errors[i] = weights[i + 1].transpose().mmul(errors[i + 1]);
        }

        org.jblas.DoubleMatrix[] deltas;
        for (int i = weights.length - 1; i >= 0; i--) {
            if (i == 0) deltas = findDeltas(actual[i], inputs, errors[i]);
            else deltas = findDeltas(actual[i], actual[i - 1], errors[i]);
            weights[i] = weights[i].add(deltas[0]);
            biases[i] = biases[i].add(deltas[1]);
        }
    }

    private org.jblas.DoubleMatrix[] findDeltas(org.jblas.DoubleMatrix actual, org.jblas.DoubleMatrix input, org.jblas.DoubleMatrix errors) {
        org.jblas.DoubleMatrix gradient = new DoubleMatrix();
        gradient.copy(actual);
        for (int i = 0; i < gradient.data.length; i++) {
            gradient.data[i] = dactivation.apply(gradient.data[i]);
        }
        gradient = gradient.mul(errors);
        gradient = gradient.mmul(learningRate);

        org.jblas.DoubleMatrix inputsT = input.transpose();
        org.jblas.DoubleMatrix weightsDeltas = gradient.mmul(inputsT);

        return new org.jblas.DoubleMatrix[]{weightsDeltas, gradient};
    }

    public org.jblas.DoubleMatrix[] getWeights() {
        return weights;
    }
}
