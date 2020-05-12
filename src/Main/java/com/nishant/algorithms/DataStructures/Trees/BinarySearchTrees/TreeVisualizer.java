package com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees;

import com.nishant.algorithms.DataStructures.Trees.BinarySearchTrees.AVLTree.AVLTree;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class TreeVisualizer extends JPanel implements KeyListener {
  public static void main(String[] args) {
    BinaryTree<Integer> myTree = new AVLTree<>();
    TreeVisualizer treeVisualizer = new TreeVisualizer(myTree, 1600, 900);
    for (int i = 0; i < 200; i++) {
      //            myTree.insert((int)(Math.random()*500));
      myTree.insert(i);
      treeVisualizer.setTree(myTree);
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private BinaryTree<?> tree;
  private Map<Node<?>, Point> map;
  private int width, height, rootHeight;
  private double zoomFactor = 0.5;
  private JFrame frame;
  private JScrollPane scrollPane;

  public TreeVisualizer(BinaryTree<?> tree, int width, int height) {
    this.tree = tree;
    map = new HashMap<>();

    JFrame frame = new JFrame("Visualizing the tree!");
    frame.setBounds(100, 100, width, height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    this.setBackground(Color.WHITE);
    this.setLayout(null);
    this.setPreferredSize(new Dimension(width, height));
    scrollPane = new JScrollPane(this);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    frame.add(scrollPane);
    frame.setVisible(true);
  }

  public void setTree(BinaryTree<?> tree) {
    this.tree = tree;
    repaint();
  }

  private void setCoords() {
    map = new HashMap<>();
    this.rootHeight = tree.getHeight();
    this.height = ((int) (rootHeight * 100 * zoomFactor));
    this.width =
            ((int)
                    ((maxLeft(tree.getRoot()) + maxRight(tree.getRoot()))
                            * (this.height)
                            * 5
                            * zoomFactor));
    this.setPreferredSize(new Dimension(width, height));
    setCoords(tree.getRoot(), 1, 0, false);
  }

  private int maxLeft(Node<?> root) {
    if (root.getLeft() == null || root.getLeft().isNull()) return 1;
    else return 1 + maxLeft(root.getLeft());
  }

  private int maxRight(Node<?> root) {
    if (root.getRight() == null || root.getRight().isNull()) return 1;
    else return 1 + maxRight(root.getRight());
  }

  private void setCoords(Node<?> root, int level, int prevX, boolean leftSide) {
    if (root == null || root.isNull()) return;

    int x, y;
    if (leftSide) x = prevX - ((int) (width / Math.pow(2, level) * zoomFactor * zoomFactor));
    else x = prevX + ((int) (width / Math.pow(2, level) * zoomFactor * zoomFactor));

    y = ((int) (height / rootHeight * level * zoomFactor));
    map.put(root, new Point(x, y));

    setCoords(root.getLeft(), level + 1, x, true);
    setCoords(root.getRight(), level + 1, x, false);
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    setCoords();
    this.setPreferredSize(new Dimension(this.width, this.height));
    scrollPane.setViewportView(this);

    g.setColor(Color.BLACK);
    g.setFont(new Font("Arial", Font.PLAIN, 20));

    int x, y, textX, textY, radius = 20;
    FontMetrics metrics = g.getFontMetrics();
    for (Node<?> node : tree) {
      if (node.isNull()) continue;
      x = ((int) map.get(node).getX());
      y = ((int) map.get(node).getY());
      String text = node.getVal().toString();
      JLabel label = new JLabel(text);
      //            label.set
      textX = x - metrics.stringWidth(text) / 2;
      textY = y;
      g.drawString(text, textX, textY);
      g.drawOval(x - radius, y - radius, radius * 2, radius * 2);

      if (map.containsKey(node.getLeft()))
        g.drawLine(
                x, y, ((int) map.get(node.getLeft()).getX()), ((int) map.get(node.getLeft()).getY()));
      if (map.containsKey(node.getRight()))
        g.drawLine(
                x, y, ((int) map.get(node.getRight()).getX()), ((int) map.get(node.getRight()).getY()));
    }
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
  }
}
