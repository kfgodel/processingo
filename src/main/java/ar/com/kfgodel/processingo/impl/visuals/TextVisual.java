package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents the visual description of text for processing
 * <p>
 * Created by tenpines on 28/10/15.
 */
public class TextVisual implements VisualDescription {

  private String text;
  private Vector2d position;

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.text(text, position.x(), position.y());
  }

  public static TextVisual create(String text, Vector2d position) {
    TextVisual visual = new TextVisual();
    visual.text = text;
    visual.position = position;
    return visual;
  }

}
