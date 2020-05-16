package com.nishant.algorithms.neuralnetworks;

import org.jblas.DoubleMatrix;

import java.util.function.Function;

/**
 * You need jblas library installed to run this.
 * @see <a href="http://jblas.org/">http://jblas.org/</a>
 */

public class EfficientNeuralNetwork {
    private DoubleMatrix[] weights;
    private DoubleMatrix[] biases;
    private double learningRate;
    private Function<Double, Double> activation, dactivation;

    public EfficientNeuralNetwork(int inputs, int outputs, double learningRate, int... hiddenLayers) {
        if (hiddenLayers.length < 1) throw new RuntimeException("Cannot have 0 hidden layers!");
        this.learningRate = learningRate;

        weights = new DoubleMatrix[hiddenLayers.length + 1];
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) weights[i] = DoubleMatrix.rand(hiddenLayers[i], inputs);
            else if (i == weights.length - 1) weights[i] = DoubleMatrix.rand(outputs, hiddenLayers[i - 1]);
            else weights[i] = DoubleMatrix.rand(hiddenLayers[i], hiddenLayers[i - 1]);
        }
        biases = new DoubleMatrix[hiddenLayers.length + 1];
        for (int i = 0; i < biases.length; i++) {
            if (i == biases.length - 1) biases[i] = DoubleMatrix.rand(outputs, 1);
            else biases[i] = DoubleMatrix.rand(hiddenLayers[i], 1);
        }

        activation = (x) -> 1 / (1 + Math.exp(-x));
        dactivation = (x) -> x * (1 - x);

    }

    public double[] predict(double[] inputArr) {
        DoubleMatrix previous = new DoubleMatrix(inputArr);

        for (int i = 0; i < weights.length; i++) {
            previous = feedForward(previous, weights[i], biases[i]);
        }

        return previous.toArray();
    }

    private DoubleMatrix feedForward(DoubleMatrix inputs, DoubleMatrix weights, DoubleMatrix biases) {
        DoubleMatrix res = weights.mmul(inputs);
        res = res.add(biases);
        for (int i = 0; i < res.data.length; i++) {
            res.data[i] = activation.apply(res.data[i]);
        }

        return res;
    }

    public void train(double[] inputArr, double[] targetArr) {
        DoubleMatrix inputs = new DoubleMatrix(inputArr), targets = new DoubleMatrix(targetArr);

        DoubleMatrix[] actual = new DoubleMatrix[weights.length];
        for (int i = 0; i < weights.length; i++) {
            if (i == 0) actual[i] = feedForward(inputs, weights[i], biases[i]);
            else actual[i] = feedForward(actual[i - 1], weights[i], biases[i]);
        }

        DoubleMatrix[] errors = new DoubleMatrix[weights.length];
        for (int i = errors.length - 1; i >= 0; i--) {
            if (i == errors.length - 1) errors[i] = targets.sub(actual[i]);
            else errors[i] = weights[i + 1].transpose().mmul(errors[i + 1]);
        }

        DoubleMatrix[] deltas;
        for (int i = weights.length - 1; i >= 0; i--) {
            if (i == 0) deltas = findDeltas(actual[i], inputs, errors[i]);
            else deltas = findDeltas(actual[i], actual[i - 1], errors[i]);
            weights[i] = weights[i].add(deltas[0]);
            biases[i] = biases[i].add(deltas[1]);
        }
    }

    private DoubleMatrix[] findDeltas(DoubleMatrix actual, DoubleMatrix input, DoubleMatrix errors) {
        DoubleMatrix gradient = new DoubleMatrix();
        gradient.copy(actual);
        for (int i = 0; i < gradient.data.length; i++) {
            gradient.data[i] = dactivation.apply(gradient.data[i]);
        }
        gradient = gradient.mul(errors);
        gradient = gradient.mmul(learningRate);

        DoubleMatrix inputsT = input.transpose();
        DoubleMatrix weightsDeltas = gradient.mmul(inputsT);

        return new DoubleMatrix[]{weightsDeltas, gradient};
    }

    public DoubleMatrix[] getWeights() {
        return weights;
    }
}
