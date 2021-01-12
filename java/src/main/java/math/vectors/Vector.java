package math.vectors;

@SuppressWarnings("ALL")
public class Vector {
  private final double x;
  private final double y;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double magnitude() {
    return Math.sqrt(x * x + y * y);
  }

  public double angle() {
    return Math.atan2(y, x);
  }

  public Vector add(Vector other) {
    return new Vector(x + other.x, y + other.y);
  }

  public Vector multiply(double scalar) {
    return new Vector(x * scalar, y * scalar);
  }

  public Vector subtract(Vector other) {
    return this.add(other.multiply(-1));
  }

  @SuppressWarnings("unused")
  public double dotProduct(Vector other) {
    return x * other.x + y * other.y;
  }
}
