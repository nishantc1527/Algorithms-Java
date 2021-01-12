package neuralnetworks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;
import neuralnetworks.mnistdata.MnistEntry;
import neuralnetworks.mnistdata.MnistLoader;

public class MNISTTrainer extends JPanel {
  private static final int WIDTH = 900, HEIGHT = 900;
  private final Object imgLock = new Object();
  private BufferedImage img;
  private int label;
  private int i;
  private int numCorrect;

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

  public static void main(String[] args) {
    new MNISTTrainer().run();
  }

  public void run() {
    MnistLoader loader = new MnistLoader();
    MnistEntry[] trainingEntries = null, testingEntries = null;
    MultilayeredNeuralNetwork nn =
        new MultilayeredNeuralNetwork(28 * 28, 10, 0.1, 28 * 28 * 2, 28 * 28 * 2);
    double[] inputArr, outputArr;
    String path = "src/Main/java/com/nishant/algorithms/NeuralNetworks/MNISTData";
    try {
      trainingEntries = loader.readDecompressedTraining(path);
      testingEntries = loader.readDecompressedTesting(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    assert trainingEntries != null && testingEntries != null;

    inputArr = new double[trainingEntries[0].getImageData().length];
    double[][] expectedOutputs = new double[10][10];
    for (int j = 0; j < expectedOutputs.length; j++) {
      expectedOutputs[j][j] = 1;
    }

    int imgScale = WIDTH / trainingEntries[0].getNumRows();

    i = 0;
    for (MnistEntry entry : trainingEntries) {
      synchronized (imgLock) {
        img = scale(entry.createImage(), imgScale, imgScale);
        label = entry.getLabel();
      }

      repaint();

      byte[] bytes = entry.getImageData();
      for (int i = 0; i < bytes.length; i++) {
        inputArr[i] = bytes[i] / 128.0;
      }
      outputArr = expectedOutputs[label];
      nn.train(
          Arrays.copyOf(inputArr, inputArr.length), Arrays.copyOf(outputArr, outputArr.length));

      i++;

      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    i = 0;
    numCorrect = 0;

    for (MnistEntry entry : testingEntries) {
      synchronized (imgLock) {
        img = scale(entry.createImage(), imgScale, imgScale);
        label = entry.getLabel();
      }

      byte[] bytes = entry.getImageData();
      for (int i = 0; i < bytes.length; i++) {
        inputArr[i] = bytes[i] / 128.0;
      }
      outputArr = nn.predict(inputArr);
      double maxVal = -1, maxIndex = -1;
      for (int j = 0; j < outputArr.length; j++) {
        if (outputArr[j] > maxVal) {
          maxIndex = j;
          maxVal = outputArr[j];
        }
      }

      if (maxIndex == label) {
        numCorrect++;
      }

      repaint();

      i++;

      try {
        Thread.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    synchronized (imgLock) {
      if (img == null) return;
      g.drawImage(img, 0, 0, null);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.BOLD, 50));
      g.drawString(String.valueOf(label), img.getWidth() / 10, img.getHeight() * 9 / 10);
      g.drawString(String.valueOf(i), img.getWidth() * 7 / 10, img.getHeight() * 9 / 10);
      g.drawString(String.valueOf(numCorrect), img.getWidth() / 10, img.getHeight() / 10);
    }
  }

  private BufferedImage scale(BufferedImage img, int xscale, int yscale) {
    BufferedImage res =
        new BufferedImage(
            img.getWidth() * xscale, img.getHeight() * yscale, BufferedImage.TYPE_INT_ARGB);
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        for (int k = 0; k < xscale; k++) {
          for (int l = 0; l < yscale; l++) {
            res.setRGB(i * xscale + k, j * yscale + l, img.getRGB(i, j));
          }
        }
      }
    }

    return res;
  }
}
