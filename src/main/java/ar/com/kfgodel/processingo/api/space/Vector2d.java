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

  float x();

  float y();
}
