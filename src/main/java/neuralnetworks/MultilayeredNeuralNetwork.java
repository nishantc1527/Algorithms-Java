package com.nishant.algorithms.neuralnetworks;

import com.nishant.algorithms.math.matrices.Matrix;

import java.util.function.Function;

public class MultilayeredNeuralNetwork {
  private Matrix[] weights;
  private Matrix[] biases;
  private double learningRate;
  private Function<Double, Double> activation, dactivation;

  public MultilayeredNeuralNetwork(
      int inputs, int outputs, double learningRate, int... hiddenLayers) {
    if (hiddenLayers.length < 1) throw new RuntimeException("Cannot have 0 hidden layers!");
    this.learningRate = learningRate;

    weights = new Matrix[hiddenLayers.length + 1];
    for (int i = 0; i < weights.length; i++) {
      if (i == 0) weights[i] = Matrix.randomize(hiddenLayers[i], inputs);
      else if (i == weights.length - 1) weights[i] = Matrix.randomize(outputs, hiddenLayers[i - 1]);
      else weights[i] = Matrix.randomize(hiddenLayers[i], hiddenLayers[i - 1]);
    }
    biases = new Matrix[hiddenLayers.length + 1];
    for (int i = 0; i < biases.length; i++) {
      if (i == biases.length - 1) biases[i] = Matrix.randomize(outputs, 1);
      else biases[i] = Matrix.randomize(hiddenLayers[i], 1);
    }

    activation = (x) -> 1 / (1 + Math.exp(-x));
    dactivation = (x) -> x * (1 - x);
  }

  public double[] predict(double[] inputArr) {
    Matrix previous = Matrix.colMatrixFromArray(inputArr);

    for (int i = 0; i < weights.length; i++) {
      previous = feedForward(previous, weights[i], biases[i]);
    }

    return previous.colMatrixToArray();
  }

  private Matrix feedForward(Matrix inputs, Matrix weights, Matrix biases) {
    Matrix res = weights.multiply(inputs);
    res = res.add(biases);
    res = res.forEach(this.activation);

    return res;
  }

  public void train(double[] inputArr, double[] targetArr) {
    Matrix inputs = Matrix.colMatrixFromArray(inputArr),
        targets = Matrix.colMatrixFromArray(targetArr);

    Matrix[] actual = new Matrix[weights.length];
    for (int i = 0; i < weights.length; i++) {
      if (i == 0) actual[i] = feedForward(inputs, weights[i], biases[i]);
      else actual[i] = feedForward(actual[i - 1], weights[i], biases[i]);
    }

    Matrix[] errors = new Matrix[weights.length];
    for (int i = errors.length - 1; i >= 0; i--) {
      if (i == errors.length - 1) errors[i] = targets.subtract(actual[i]);
      else errors[i] = weights[i + 1].transpose().multiply(errors[i + 1]);
    }

    Matrix[] deltas;
    for (int i = weights.length - 1; i >= 0; i--) {
      if (i == 0) deltas = findDeltas(actual[i], inputs, errors[i]);
      else deltas = findDeltas(actual[i], actual[i - 1], errors[i]);
      weights[i] = weights[i].add(deltas[0]);
      biases[i] = biases[i].add(deltas[1]);
    }
  }

  private Matrix[] findDeltas(Matrix actual, Matrix input, Matrix errors) {
    Matrix gradient = actual.forEach(dactivation);
    gradient = gradient.hadamardMultiply(errors);
    gradient = gradient.multiply(learningRate);

    Matrix inputsT = input.transpose();
    Matrix weightsDeltas = gradient.multiply(inputsT);

    return new Matrix[] {weightsDeltas, gradient};
  }

  public Matrix[] getWeights() {
    return weights;
  }
}
