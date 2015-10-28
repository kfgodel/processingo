package ar.com.kfgodel.processingo.api.viewports;

import ar.com.kfgodel.processingo.impl.viewports.ViewSizeImpl;

/**
 * This type represents the size of a viewport
 *
 * Created by tenpines on 27/10/15.
 */
public interface ViewSize {

  /**
   * Creates a view size for the given dimensions
   * @param width The width in pixels
   * @param height The height in pixels
   * @return The created size
   */
  static ViewSize of(int width, int height) {
    return new ViewSizeImpl(width, height);
  }

  int width();

  int height();
}
