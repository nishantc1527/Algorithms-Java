package com.nishant.algorithms.neuralnetworks;

public class OneHiddenLayerNeuralNetwork {
    private com.nishant.algorithms.Math.Matrices.Matrix weightsIH, weightsHO, biasH, biasO;
    private double learningRate;

    public OneHiddenLayerNeuralNetwork(int inputs, int hidden, int output) {

        weightsIH = com.nishant.algorithms.Math.Matrices.Matrix.randomize(hidden, inputs);
        weightsHO = com.nishant.algorithms.Math.Matrices.Matrix.randomize(output, hidden);
        biasH = com.nishant.algorithms.Math.Matrices.Matrix.randomize(hidden, 1);
        biasO = com.nishant.algorithms.Math.Matrices.Matrix.randomize(output, 1);

        learningRate = 5;
    }

    public double[] predict(double[] inputArray) {
        com.nishant.algorithms.Math.Matrices.Matrix inputs = com.nishant.algorithms.Math.Matrices.Matrix.colMatrixFromArray(inputArray);

        com.nishant.algorithms.Math.Matrices.Matrix hidden = weightsIH.multiply(inputs);
        hidden = hidden.add(biasH);
        hidden = hidden.forEach(this::sigmoid);

        com.nishant.algorithms.Math.Matrices.Matrix output = weightsHO.multiply(hidden);
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

        com.nishant.algorithms.Math.Matrices.Matrix inputs = com.nishant.algorithms.Math.Matrices.Matrix.colMatrixFromArray(inputArr);
        com.nishant.algorithms.Math.Matrices.Matrix hidden = weightsIH.multiply(inputs);
        hidden = hidden.add(biasH);
        hidden = hidden.forEach(this::sigmoid);

        com.nishant.algorithms.Math.Matrices.Matrix outputs = weightsHO.multiply(hidden);
        outputs = outputs.add(biasO);
        outputs = outputs.forEach(this::sigmoid);

        com.nishant.algorithms.Math.Matrices.Matrix targets = com.nishant.algorithms.Math.Matrices.Matrix.colMatrixFromArray(targetArr);

        // Error = targets - outputs
        com.nishant.algorithms.Math.Matrices.Matrix outputErrors = targets.subtract(outputs);

        com.nishant.algorithms.Math.Matrices.Matrix weightsHOT = weightsHO.transpose();
        com.nishant.algorithms.Math.Matrices.Matrix hiddenErrors = weightsHOT.multiply(outputErrors);

        com.nishant.algorithms.Math.Matrices.Matrix gradients = outputs.forEach(this::dsigmoid);
        gradients = gradients.hadamardMultiply(outputErrors);
        gradients = gradients.multiply(learningRate);

        com.nishant.algorithms.Math.Matrices.Matrix hiddenT = hidden.transpose();
        com.nishant.algorithms.Math.Matrices.Matrix weightsHODeltas = gradients.multiply(hiddenT);

        weightsHO = weightsHO.add(weightsHODeltas);
        biasO = biasO.add(gradients);

//        Matrix weightsHOT = weightsHO.transpose();
//        Matrix hiddenErrors = weightsHOT.multiply(outputErrors);

        com.nishant.algorithms.Math.Matrices.Matrix hiddenGradient = hidden.forEach(this::dsigmoid);
        hiddenGradient = hiddenGradient.hadamardMultiply(hiddenErrors);
        hiddenGradient = hiddenGradient.multiply(learningRate);

        com.nishant.algorithms.Math.Matrices.Matrix inputsT = inputs.transpose();
        com.nishant.algorithms.Math.Matrices.Matrix weightsIHDeltas = hiddenGradient.multiply(inputsT);

        weightsIH = weightsIH.add(weightsIHDeltas);
        biasH = biasH.add(hiddenGradient);
    }
}
