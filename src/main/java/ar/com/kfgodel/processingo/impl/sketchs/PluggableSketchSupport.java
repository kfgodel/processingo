package ar.com.kfgodel.processingo.impl.sketchs;

import ar.com.kfgodel.processingo.api.input.MouseEventContext;
import ar.com.kfgodel.processingo.api.sketchs.PluggableSketch;

import java.util.function.Consumer;

/**
 * This type facilitates the extension of pluggable sketches by defining base behavior
 * Created by tenpines on 02/11/15.
 */
public class PluggableSketchSupport extends SketchSupport implements PluggableSketch {

  private Consumer<MouseEventContext> mouseClickHandler = (event)->{};

  @Override
  public void plugOnMouseClicked(Consumer<MouseEventContext> mouseClickHandler) {
    this.mouseClickHandler = mouseClickHandler;
  }

  @Override
  public void onMouseClicked(MouseEventContext mouseEvent) {
    mouseClickHandler.accept(mouseEvent);
  }
}
