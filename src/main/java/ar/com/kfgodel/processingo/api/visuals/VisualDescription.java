package ar.com.kfgodel.processingo.api.visuals;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;

/**
 * This type represents a visual element (or a composition of them) that can be drawn on a ProcessingCanvas.<br>
 *   When applied on a canvas a visual description generates a pixel representation perceivable by humans
 *
 * Created by tenpines on 28/10/15.
 */
public interface VisualDescription {

  /**
   * Modifies the pixel of the canvas according to this instance reprepresentation
   * @param canvas The pixel space to affect
   */
  void applyOn(ProcessingCanvas canvas);
}
