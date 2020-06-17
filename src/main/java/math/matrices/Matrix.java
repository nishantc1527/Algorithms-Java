package math.matrices;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class Matrix {
  /** The representation of the matrix, using a 2D array */
  private double[][] matrix;

  private int rows, cols;

  /**
   * Copies the matrix from the other matrix given
   *
   * @param copy The matrix to copy data from
   */
  public Matrix(Matrix copy) {
    this(copy.matrix);
    rows = copy.rows;
    cols = copy.cols;
  }

  /**
   * Makes an empty matrix with the given number of rows and columns
   *
   * @param rows The initial number of rows
   * @param cols The initial number of columns
   */
  public Matrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    matrix = new double[rows][cols];
  }

  /**
   * Sets up the matrix with an initial set of data
   *
   * @param data The initial set of data
   */
  public Matrix(double[][] data) {
    if (!isValidData(data)) return;

    rows = data.length;
    cols = data[0].length;
    matrix = new double[rows][cols];
    setData(data);
  }

  /**
   * Gets the identity square matrix with a given number of rows and columns
   *
   * @param len The number of rows and columns
   * @return The identity matrix with the given dimensions
   */
  public static Matrix identity(int len) {
    double[][] res = new double[len][len];

    for (int i = 0; i < len; i++) {
      res[i][i] = 1;
    }

    return new Matrix(res);
  }

  /**
   * Makes a matrix with the given dimensions and filled with random values in the range [-1, 1)
   *
   * @param rows The number of rows to make the randomized matrix
   * @param cols The number of columns to make the randomized matrix
   * @return The randomized matrix
   */
  public static Matrix randomize(int rows, int cols) {
    double[][] res = new double[rows][cols];

    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        res[i][j] = Math.random();
      }
    }

    return new Matrix(res);
  }

  /**
   * Makes a new Matrix with 1 column, given by the array input
   *
   * @param arr The input to make the new matrix from
   * @return The generated matrix
   */
  public static Matrix colMatrixFromArray(double[] arr) {
    double[][] res = new double[arr.length][1];
    for (int i = 0; i < arr.length; i++) {
      res[i][0] = arr[i];
    }

    return new Matrix(res);
  }

  /**
   * Checks if a set of data, in a 2D array, is a valid matrix
   *
   * @param data The data to check
   * @return Whether the data is valid
   */
  public boolean isValidData(double[][] data) {
    if (data == null) return false;
    if (data.length == 0) return false;
    for (double[] arr : data) if (arr == null) return false;
    int len = data[0].length;
    for (double[] arr : data) {
      if (arr.length != len) return false;
    }

    return true;
  }

  /**
   * Sets the data in this matrix at the given position (i, j)
   *
   * @param i i-position of the value
   * @param j j-position of the value
   */
  public void setData(int i, int j, double value) {
    if (i >= 0 && i < rows && j >= 0 && j < cols) {
      matrix[i][j] = value;
    }
  }

  /**
   * Gets the data in this matrix at a given (i, j) position
   *
   * @param i i-position of the value
   * @param j j-position of the value
   * @return The value at the given position
   */
  public double getData(int i, int j) {
    if (i >= 0 && i < rows && j >= 0 && j < cols) {
      return matrix[i][j];
    } else return 0;
  }

  /**
   * Gets the data that is stored in this matrix, in the form of a 2D array
   *
   * @return The 2D array representation of the matrix
   */
  public double[][] getData() {
    return Arrays.copyOf(matrix, matrix.length);
  }

  /**
   * The sets the data in this matrix to the data given. This operation can fail if the data given
   * has different dimensions as the matrix
   *
   * @param data The data to set into this matrix
   */
  public void setData(double[][] data) {
    if (data.length != rows) return;
    for (int i = 0; i < rows; i++) {
      if (data[i].length != cols) return;
      matrix[i] = Arrays.copyOf(data[i], data[i].length);
    }
  }

  /**
   * Matrix adds this matrix to the other given matrix. This operation can fail (return null) if the
   * size of the matrix is not equal to the size of the other matrix
   *
   * @param other The matrix to add to
   * @return The sum of the two matrices
   */
  public Matrix add(Matrix other) {
    if (rows != other.rows || cols != other.cols) return null;
    double[][] res = new double[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        res[i][j] = matrix[i][j] + other.matrix[i][j];
      }
    }

    return new Matrix(res);
  }

  /**
   * Subtracts the other matrix from this one
   *
   * @param other The matrix to be subtracted
   * @return The difference of the two matrices
   */
  public Matrix subtract(Matrix other) {
    return this.add(other.multiply(-1));
  }

  /**
   * Multiplies this matrix with another given matrix
   *
   * @param other The matrix to multiply by
   * @return The product of the two matrices
   */
  public Matrix multiply(Matrix other) {
    if (cols != other.rows) return null;

    double[][] res = new double[rows][other.cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < other.cols; j++) {
        for (int k = 0; k < cols; k++) {
          res[i][j] += matrix[i][k] * other.matrix[k][j];
        }
      }
    }

    return new Matrix(res);
  }

  public Matrix hadamardMultiply(Matrix other) {
    if (rows != other.rows || cols != other.cols) return null;

    double[][] res = new double[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        res[i][j] = matrix[i][j] * other.matrix[i][j];
      }
    }

    return new Matrix(res);
  }

  /**
   * Scalar multiplies this matrix with the given scalar
   *
   * @param scalar The scalar to multiply by
   * @return The product of the multiplication
   */
  public Matrix multiply(double scalar) {
    double[][] res = new double[rows][cols];

    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[i].length; j++) {
        res[i][j] = matrix[i][j] * scalar;
      }
    }

    return new Matrix(res);
  }

  /**
   * Gets the transposition of this matrix
   *
   * @return The transposition
   */
  public Matrix transpose() {
    double[][] res = new double[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        res[j][i] = matrix[i][j];
      }
    }

    return new Matrix(res);
  }

  /**
   * Gets a specific row of this Matrix, also represented as a matrix
   *
   * @param row The row to get
   * @return The row at the given position
   */
  public Matrix getRow(int row) {
    if (row > rows) return null;

    double[][] res = new double[1][cols];
    for (int i = 0; i < cols; i++) {
      res[0][i] = matrix[row][i];
    }

    return new Matrix(res);
  }

  /**
   * Gets a specific col of this Matrix, also represented as a matrix
   *
   * @param col The column to get
   * @return The col at the given position
   */
  public Matrix getColumn(int col) {
    if (col > cols) return null;

    double[][] res = new double[rows][1];
    for (int i = 0; i < rows; i++) {
      res[i][0] = matrix[i][col];
    }

    return new Matrix(res);
  }

  public double[] colMatrixToArray() {
    double[] res = new double[rows];
    for (int i = 0; i < rows; i++) {
      res[i] = matrix[i][0];
    }

    return res;
  }

  /**
   * Applies the given function to each value in the matrix
   *
   * @param func The function to apply
   * @return The result after applying the function
   */
  public Matrix forEach(Function<Double, Double> func) {
    double[][] res = new double[rows][cols];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        res[i][j] = func.apply(matrix[i][j]);
      }
    }

    return new Matrix(res);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n\t");
    for (int i = 0; i < rows - 1; i++) {
      sb.append(Arrays.toString(matrix[i]));
      sb.append(",\n\t");
    }
    sb.append(Arrays.toString(matrix[rows - 1]));
    sb.append("\n}").append(", rows = ").append(rows).append(", cols = ").append(cols);

    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Matrix)) return false;
    Matrix matrix1 = (Matrix) o;
    if (rows != matrix1.rows || cols != matrix1.cols) return false;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != matrix1.matrix[i][j]) return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(rows, cols);
    result = 31 * result + Arrays.hashCode(matrix);
    return result;
  }
}
