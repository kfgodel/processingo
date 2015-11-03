package ar.com.kfgodel.processingo.api.sketchs;

import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.input.MouseEventContext;

import java.util.function.Consumer;

/**
 * This type represents a sketch that accepts functions as method implementations.<br>
 *   When invoked it delegates to the specified functions its behavior
 *
 * Created by tenpines on 02/11/15.
 */
public interface PluggableSketch extends ProcessingSketch {
  /**
   * Defines the behavior for a mouse click event
   * @param mouseClickHandler The handler that will be invoked
   */
  void plugOnMouseClicked(Consumer<MouseEventContext> mouseClickHandler);
}
