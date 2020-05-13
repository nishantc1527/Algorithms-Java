package com.nishant.algorithms.NeuralNetworks.MNISTData;

import javax.naming.directory.AttributeModificationException;
import java.io.*;

public class MNISTLoader {
    public Data[] loadTesting() {
        InputStream fileIO = null;
        byte[] imageBytes = new byte[0], labelBytes = new byte[0];

        try {
            fileIO = new FileInputStream(new File(
                    "src/Main/java/com/nishant/algorithms/NeuralNetworks/MNISTData/training_images.gz"));
            imageBytes = fileIO.readAllBytes();
            fileIO = new FileInputStream(new File(
                    "src/Main/java/com/nishant/algorithms/NeuralNetworks/MNISTData/training_labels.gz"));
            labelBytes = fileIO.readAllBytes();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        long num = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(imageBytes[4 + i] - Byte.MIN_VALUE);
            System.out.println(num);
            num |= (imageBytes[4 + i] - Byte.MIN_VALUE) << (8 * (4 - i - 1));
        }
        System.out.println(num);

        return null;
    }

    public static void main(String[] args) throws IOException {
        new MNISTLoader().loadTesting();
    }

    public class Data {
        private double[][] image;
        private int label;

        public double[][] getImage() {return image;}

        public int getLabel() {return label;}

        private void setImage(double[][] image) {this.image = image;}
        private void setLabel(int label) {this.label = label;}
    }
}
