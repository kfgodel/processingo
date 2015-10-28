package ar.com.kfgodel.processingo.impl.viewports;

import ar.com.kfgodel.processingo.api.viewports.ViewSize;

/**
 * Implementation of a view size
 * Created by tenpines on 27/10/15.
 */
public class ViewSizeImpl implements ViewSize {

  private final int width;
  private final int height;

  public ViewSizeImpl(final int width, final int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public int width() {
    return width;
  }

  @Override
  public int height() {
    return height;
  }
}
