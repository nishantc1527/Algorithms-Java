package neuralnetworks;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("ALL")
public class Tester extends JPanel {
  private static final int WIDTH = 900, HEIGHT = 900;
  private final Map<Point, Integer> points = new HashMap<>();
  private final int trainingSize;
  private Perceptron perceptron;
  private int frameCount = 0;

  public Tester(int width, int height) {
    JFrame frame = new JFrame("Testing single perceptrons");
    frame.setBounds(100, 100, width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    this.setBackground(Color.WHITE);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(width, height));
    frame.add(this);
    frame.setVisible(true);

    trainingSize = 100;
  }

  public static void main(String[] args) {
    //        Tester tester = new Tester(WIDTH, HEIGHT);
    //
    //        tester.perceptron = new Perceptron();
    //
    //        tester.run();

    OneHiddenLayerNeuralNetwork nn = new OneHiddenLayerNeuralNetwork(2, 4, 1);
    double[][][] trainingData = new double[4][2][];
    trainingData[0][0] = new double[] {1, 1};
    trainingData[0][1] = new double[] {0};
    trainingData[1][0] = new double[] {0, 0};
    trainingData[1][1] = new double[] {0};
    trainingData[2][0] = new double[] {1, 0};
    trainingData[2][1] = new double[] {1};
    trainingData[3][0] = new double[] {0, 1};
    trainingData[3][1] = new double[] {1};

    for (int i = 0; i < 50000; i++) {
      for (int j = 0; j < trainingData.length; j++) {
        int index = ((int) (Math.random() * trainingData.length));
        nn.train(trainingData[index][0], trainingData[index][1]);
        //                nn.train(trainingData[j][0], trainingData[j][1]);
      }
    }

    System.out.println(Arrays.toString(nn.predict(trainingData[0][0])));
    System.out.println(Arrays.toString(nn.predict(trainingData[1][0])));
    System.out.println(Arrays.toString(nn.predict(trainingData[2][0])));
    System.out.println(Arrays.toString(nn.predict(trainingData[3][0])));

    //        MultilayeredNeuralNetwork mnn = new MultilayeredNeuralNetwork(2, 1, 1, 1);
    //        System.out.println(Arrays.toString(mnn.predict(new double[]{0, 1})));
  }

  @SuppressWarnings("unused")
  public void run() {
    Point current;
    for (int i = 0; i < trainingSize; i++) {
      current = new Point(((int) (Math.random() * WIDTH)), ((int) (Math.random() * HEIGHT)));
      if (current.x > current.y) {
        points.put(current, 1);
      } else points.put(current, -1);
    }

    while (true) {
      repaint();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Point current = new Point(((int) (Math.random() * WIDTH)), ((int) (Math.random() * HEIGHT)));
    if (current.x > current.y) {
      points.put(current, 1);
    } else points.put(current, -1);

    if (frameCount % 3 == 0) {
      double[] inputs = new double[2];
      for (Point point : points.keySet()) {
        inputs[0] = point.x;
        inputs[1] = point.y;
        perceptron.train(inputs, points.get(point));
      }
    }

    g.drawLine(0, 0, WIDTH, HEIGHT);
    double guess;
    for (Point point : points.keySet()) {
      guess = perceptron.guess(new double[] {point.x, point.y});
      if (guess == points.get(point)) g.setColor(Color.GREEN);
      else g.setColor(Color.RED);

      g.fillOval(point.x, point.y, 30, 30);
      g.setColor(Color.BLACK);
      g.drawOval(point.x, point.y, 30, 30);
    }

    frameCount++;
  }
}
