package ar.com.kfgodel.processingo.api.space;

import ar.com.kfgodel.processingo.impl.space.Vector2dImpl;

/**
 * This type represents a 2d vector
 * Created by tenpines on 28/10/15.
 */
public interface Vector2d {

  /**
   * Creates a new vector
   * @param x the value for x
   * @param y the value for y
   * @return The created vector
   */
  static Vector2d xy(float x, float y) {
    return new Vector2dImpl(x, y);
  }

  /**
   * Facility method for doubles instead of floats
   */
  static Vector2d xy(double x, double y) {
    return xy((float)x, (float)y);
  }


  float x();

  float y();

  /**
   * Adds this vector to the one given
   * @param other The vector to add this to
   * @return The new vector with the result of the addition
   */
  Vector2d plus(Vector2d other);

  /**
   * Inverts the sign of the x value
   */
  Vector2d invertX();

  /**
   * Inverts the sign of the y value
   */
  Vector2d invertY();

  /**
   * Returns the inner elementProduct of each component as a new vector
   */
  Vector2d elementProduct(Vector2d other);

  /**
   * Multiplies each element by the given scalar
   * @param scalar The factor to scale this vector
   */
  Vector2d scale(double scalar);

  /**
   * Applies an int transformation to each component (each scalar component is rounded to its nearest to 0 asInteger)
   * @return The resulting vector
   */
  Vector2d integered();

  /**
   * Rotates this vector by the given angle in degrees
   * @param degrees The angle to rotate this vector
   * @return The new rotated vector
   */
  Vector2d rotate(float degrees);

  /**
   * Inverts the direction of this vector on each coordinate
   * @return The new vector
   */
  Vector2d invert();
}
