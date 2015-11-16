package ar.com.kfgodel.processingo.impl.space;

import ar.com.kfgodel.processingo.api.space.Vector2d;

/**
 * This type is the implementation of a 2d vector
 * Created by tenpines on 28/10/15.
 */
public class Vector2dImpl implements Vector2d {
  private final float x;
  private final float y;

  public Vector2dImpl(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public float x() {
    return x;
  }

  @Override
  public float y() {
    return y;
  }

  @Override
  public Vector2d plus(Vector2d other) {
    return Vector2d.xy(this.x + other.x(), this.y + other.y());
  }

  @Override
  public Vector2d invertX() {
    return Vector2d.xy(-x, y);
  }

  @Override
  public Vector2d invertY() {
    return Vector2d.xy(x, -y);
  }

  @Override
  public Vector2d elementProduct(Vector2d other) {
    return Vector2d.xy(x * other.x(), y * other.y());
  }

  @Override
  public Vector2d scale(double scalar) {
    return Vector2d.xy(this.x * scalar, this.y * scalar);
  }

  @Override
  public Vector2d integered() {
    return Vector2d.xy(asInteger(this.x), asInteger(this.y));
  }

  @Override
  public Vector2d rotate(float degrees) {
    double angleInRadians = Math.toRadians(degrees);
    double cos = Math.cos(angleInRadians);
    double sin = Math.sin(angleInRadians);
    return Vector2d.xy(x * cos - y * sin, x * sin + y * cos);
  }

  @Override
  public Vector2d invert() {
    return Vector2d.xy(-x, -y);
  }

  private double asInteger(double val) {
    if (val < 0) {
      return Math.ceil(val);
    }
    return Math.floor(val);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Vector2d)) return false;

    Vector2d vector2d = (Vector2d) o;

    if (vector2d.x() != x) return false;
    return vector2d.y() == y;
  }

  @Override
  public int hashCode() {
    int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
    result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
    return result;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "( " + x + ", " + y + ")";
  }
}
