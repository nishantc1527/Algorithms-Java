package com.nishant.algorithms.NeuralNetworks;

import com.nishant.algorithms.Matrices.Matrix;

public class OneHiddenLayerNeuralNetwork {
    private Matrix weightsIH, weightsHO, biasH, biasO;
    private double learningRate;

    public OneHiddenLayerNeuralNetwork(int inputs, int hidden, int output) {

        weightsIH = Matrix.randomize(hidden, inputs);
        weightsHO = Matrix.randomize(output, hidden);
        biasH = Matrix.randomize(hidden, 1);
        biasO = Matrix.randomize(output, 1);

        learningRate = 5;
    }

    public double[] predict(double[] inputArray) {
        Matrix inputs = Matrix.colMatrixFromArray(inputArray);
        Matrix hidden = weightsIH.multiply(inputs);
        hidden = hidden.add(biasH);
        hidden = hidden.forEach(this::sigmoid);

        Matrix output = weightsHO.multiply(hidden);
        output = output.add(biasO);
        output = output.forEach(this::sigmoid);

        return output.colMatrixToArray();
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double dsigmoid(double x) {
        return x * (1 - x);
    }

    public void train(double[] inputArr, double[] targetArr) {

        Matrix inputs = Matrix.colMatrixFromArray(inputArr);
        Matrix hidden = weightsIH.multiply(inputs);
        hidden = hidden.add(biasH);
        hidden = hidden.forEach(this::sigmoid);

        Matrix outputs = weightsHO.multiply(hidden);
        outputs = outputs.add(biasO);
        outputs = outputs.forEach(this::sigmoid);

        Matrix targets = Matrix.colMatrixFromArray(targetArr);

        // Error = targets - outputs
        Matrix outputErrors = targets.subtract(outputs);

        Matrix weightsHOT = weightsHO.transpose();
        Matrix hiddenErrors = weightsHOT.multiply(outputErrors);

        Matrix gradients = outputs.forEach(this::dsigmoid);
        gradients = gradients.hadamardMultiply(outputErrors);
        gradients = gradients.multiply(learningRate);

        Matrix hiddenT = hidden.transpose();
        Matrix weightsHODeltas = gradients.multiply(hiddenT);

        weightsHO = weightsHO.add(weightsHODeltas);
        biasO = biasO.add(gradients);

//        Matrix weightsHOT = weightsHO.transpose();
//        Matrix hiddenErrors = weightsHOT.multiply(outputErrors);

        Matrix hiddenGradient = hidden.forEach(this::dsigmoid);
        hiddenGradient = hiddenGradient.hadamardMultiply(hiddenErrors);
        hiddenGradient = hiddenGradient.multiply(learningRate);

        Matrix inputsT = inputs.transpose();
        Matrix weightsIHDeltas = hiddenGradient.multiply(inputsT);

        weightsIH = weightsIH.add(weightsIHDeltas);
        biasH = biasH.add(hiddenGradient);
    }
}
