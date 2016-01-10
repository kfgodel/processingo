package ar.com.kfgodel.processingo.impl.viewports;

import ar.com.kfgodel.mathe.api.BidiVector;
import ar.com.kfgodel.mathe.api.Mathe;
import ar.com.kfgodel.processingo.api.viewports.ViewSize;

/**
 * Implementation of a view size
 * Created by tenpines on 27/10/15.
 */
public class ViewSizeImpl implements ViewSize {

  private final BidiVector size;

  public ViewSizeImpl(final int width, final int height) {
    this.size = Mathe.vector(width, height);
  }

  @Override
  public int width() {
    return size.width().asInt();
  }

  @Override
  public int height() {
    return size.height().asInt();
  }
}
