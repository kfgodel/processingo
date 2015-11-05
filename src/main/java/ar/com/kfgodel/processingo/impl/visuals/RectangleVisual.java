package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents a rectangle drawing
 * Created by tenpines on 04/11/15.
 */
public class RectangleVisual implements VisualDescription {

  private Vector2d position;
  private Vector2d size;

  public static RectangleVisual create(Vector2d position, Vector2d size) {
    RectangleVisual visual = new RectangleVisual();
    visual.position = position;
    visual.size = size;
    return visual;
  }

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.rect(position.x(), position.y(), size.x(), size.y());
  }
}
