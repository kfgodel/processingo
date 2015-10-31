package ar.com.kfgodel.processingo.impl.visuals;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents a background color
 * Created by tenpines on 30/10/15.
 */
public class BackgroundVisual implements VisualDescription {
  private int color;

  @Override
  public void applyOn(ProcessingCanvas canvas) {
    canvas.background(color);
  }

  public static BackgroundVisual create(int color){
      BackgroundVisual visual = new BackgroundVisual();
      visual.color = color;
      return visual;
  }

}
