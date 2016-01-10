package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.mathe.api.BidiVector;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents an ellipse
 * Created by tenpines on 30/10/15.
 */
public class EllipseVisual implements VisualDescription {

  private BidiVector position;
  private float width;
  private float height;

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.ellipse(position.x().asFloat(), position.y().asFloat(), width, height);
  }

  public static EllipseVisual create(BidiVector position, float width, float height) {
    EllipseVisual visual = new EllipseVisual();
    visual.position = position;
    visual.width = width;
    visual.height = height;
    return visual;
  }

}
