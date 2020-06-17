package neuralnetworks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.*;

public class XORVisualizer extends JPanel {

  private static final int WIDTH = 900, HEIGHT = 900;
  private EfficientNeuralNetwork nn;
  private int frameCount = 0;

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

  public static void main(String[] args) {
    XORVisualizer v = new XORVisualizer();

    int[] hiddens = new int[2];
    Arrays.fill(hiddens, 10);
    v.nn = new EfficientNeuralNetwork(2, 1, 0.1, hiddens);

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(
            () -> {
              while (true) v.train();
            })
        .start();

    v.repaint();
    while (v.frameCount < Short.MAX_VALUE) {
      if (v.frameCount % 20 == 0) v.repaint();
      v.frameCount++;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    double guess;
    Color color;
    for (int i = 0; i < img.getWidth(); i++) {
      for (int j = 0; j < img.getHeight(); j++) {
        guess = nn.predict(new double[] {((double) i) / WIDTH, ((double) j) / HEIGHT})[0];
        System.out.println(guess);
        //                color = new Color(((int) (guess * (Math.pow(2, 24) - 1))));
        color = new Color(((int) (guess * 256)), ((int) (guess * 256)), ((int) (guess * 256)));
        //                color = new Color(((int) (guess)) * 256, ((int) (1 / (1 +
        // Math.exp(-guess)) * 256)),
        //                        ((int) ((guess + 1) / 2)) * 256);
        img.setRGB(i, j, color.getRGB());
        //                img.setRGB(i, j, ((int) ((double) i * j / WIDTH / HEIGHT)));
      }
    }

    g.drawImage(img, 0, 0, null);
  }

  private void train() {
    double input1, input2;
    double[] input = new double[2], output = new double[1];
    for (int i = 0; i < 200; i++) {
      input1 = Math.random() < 0.5 ? 0 : 1;
      input2 = Math.random() < 0.5 ? 0 : 1;
      //            input1 = ((int) (Math.random() * 5)) / 5.0;
      //            input2 = ((int) (Math.random() * 5)) / 5.0;
      //            input1 = Math.random();
      //            input2 = Math.random();

      input[0] = input1;
      input[1] = input2;

      //            output[0] = input1 + input2;
      output[0] = Math.abs(input1 - input2);
      //            output[0] = ((int) input1) ^ ((int) input2);
      //            output[0] = Math.abs(input1 - 0.5) > Math.abs(input2 - 0.5) ? 1 : 0;
      //            output[0] = input1 == input2 && input2 == 1 ? 1 : 0;
      //            output[0] = input1 * input2;
      //            output[0] = input1;

      nn.train(input, output);
    }
  }
}
