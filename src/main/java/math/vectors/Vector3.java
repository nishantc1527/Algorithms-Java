package math.vectors;

public class Vector3 {

  private final double x, y, z, length;
  private Vector3 normalized;

  public Vector3(final double value) {
    this(value, value, value);
  }

  public Vector3(final double x, final double y, final double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    length = Math.sqrt(norm());
  }

  public Vector3 add(final double x, final double y, final double z) {
    return new Vector3(this.x + x, this.y + y, this.z + z);
  }

  public Vector3 add(Vector3 other) {
    return add(other.x, other.y, other.z);
  }

  public Vector3 subtract(final double x, final double y, final double z) {
    return add(-x, -y, -z);
  }

  public Vector3 subtract(Vector3 other) {
    return subtract(other.x, other.y, other.z);
  }

  public Vector3 multiply(final double x, final double y, final double z) {
    return new Vector3(this.x * x, this.y * y, this.z * z);
  }

  public Vector3 multiply(final Vector3 other) {
    return multiply(other.x, other.y, other.z);
  }

  public Vector3 divide(final double x, final double y, final double z) {
    return multiply(1 / x, 1 / y, 1 / z);
  }

  public Vector3 divide(final Vector3 other) {
    return divide(other.x, other.y, other.z);
  }

  public Vector3 multiply(final double scalar) {
    return new Vector3(x * scalar, y * scalar, z * scalar);
  }

  public Vector3 normalized() {
    if (normalized == null) {
      if (length > 0) {
        double inverseLength = 1 / length;
        return normalized = new Vector3(x * inverseLength, y * inverseLength, z * inverseLength);
      } else {
        return normalized = new Vector3(1, 1, 1).normalized;
      }
    }

    return normalized;
  }

  public double dotProduct(final Vector3 other) {
    return x * other.x + y * other.y + z * other.z;
  }

  public Vector3 crossProduct(final Vector3 other) {
    return new Vector3(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
  }

  public double norm() {
    return dotProduct(this);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  public double getLength() {
    return length;
  }
}
