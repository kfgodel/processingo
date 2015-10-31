package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents an ellipse
 * Created by tenpines on 30/10/15.
 */
public class EllipseVisual implements VisualDescription {

  private Vector2d position;
  private float width;
  private float height;

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.ellipse(position.x(), position.y(), width, height);
  }

  public static EllipseVisual create(Vector2d position, float width, float height) {
    EllipseVisual visual = new EllipseVisual();
    visual.position = position;
    visual.width = width;
    visual.height = height;
    return visual;
  }

}
