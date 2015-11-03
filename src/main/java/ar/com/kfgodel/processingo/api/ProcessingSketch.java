package ar.com.kfgodel.processingo.api;

import ar.com.kfgodel.processingo.api.input.MouseEventContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingSetup;

/**
 * This type represents the user code of a processing application.<br>
 *   The sketch represents what the user wants processing to do when running
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingSketch {
  /**
   * Called when the sketch is initialized to define viewport configuration
   * for the rendering settings
   * @param configuration The configuration that can be changed before starting the actual display
   */
  void onSettings(ProcessingConfiguration configuration);

  /**
   * Invoked after the sketch viewport is initialized, this is run only once
   * allowing to draw static things, and also prepare resources
   * @param processingSetup The setup context available to the sketch
   */
  void onSetup(ProcessingSetup processingSetup);

  /**
   * Invoked on every frame after setup has been called to redraw the scene.<br>
   *   How frequent this method gets called depends on the fps configuration of the sketch and
   *   how much each frame takes to render. If it takes too much the fps goal may not be met.
   *
   * @param givenCanvas The processing space that can be drawn on
   */
  void onDraw(ProcessingCanvas givenCanvas);

  /**
   * Invoked on a mouse click and release event
   * @param mouseEvent The processing context of the mouse event
   */
  void onMouseClicked(MouseEventContext mouseEvent);
}
