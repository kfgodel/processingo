package ar.com.kfgodel.processingo.api.original;

import processing.core.PConstants;

/**
 * This type captures the possible renderers that are available to processing.<br>
 *   Opposed to the constants on PConstants, this types limits the options to only renderers
 * Created by tenpines on 27/10/15.
 */
public enum ProcessingRenderer {
  JAVA2D(PConstants.JAVA2D),
  P2D(PConstants.P2D),
  P3D(PConstants.P3D),
  PDF(PConstants.PDF),
  SVG(PConstants.SVG),
  DXF(PConstants.DXF);

  private String constant;

  ProcessingRenderer(String constantName) {
    this.constant = constantName;
  }

  public String constant() {
    return constant;
  }
}
