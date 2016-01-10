package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.mathe.api.BidiVector;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents a rectangle drawing
 * Created by tenpines on 04/11/15.
 */
public class RectangleVisual implements VisualDescription {

  private BidiVector position;
  private BidiVector size;

  public static RectangleVisual create(BidiVector position, BidiVector size) {
    RectangleVisual visual = new RectangleVisual();
    visual.position = position;
    visual.size = size;
    return visual;
  }

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.rect(position.x().asFloat(), position.y().asFloat(), size.width().asFloat(), size.height().asFloat());
  }
}
