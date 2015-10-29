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
}
