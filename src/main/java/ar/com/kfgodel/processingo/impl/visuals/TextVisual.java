package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.mathe.api.BidiVector;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents the visual description of text for processing
 * <p>
 * Created by tenpines on 28/10/15.
 */
public class TextVisual implements VisualDescription {

  private String text;
  private BidiVector position;

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.text(text, position.x().asFloat(), position.y().asFloat());
  }

  public static TextVisual create(String text, BidiVector position) {
    TextVisual visual = new TextVisual();
    visual.text = text;
    visual.position = position;
    return visual;
  }

}
