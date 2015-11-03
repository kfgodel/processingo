package ar.com.kfgodel.processingo.impl.sketchs;

import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;

/**
 * This type represents the sketch that draws the "represented world" everytime a frame is rendered.<br>
 * To draw each frame a world description is used
 * <p>
 * Created by tenpines on 28/10/15.
 */
public class DescribeWorldPerFrameSketch extends PluggableSketchSupport {

  private ViewportDefinition viewport;
  private VisualDescription worldDescription;

  @Override
  public void onSettings(ProcessingConfiguration configuration) {
    viewport.change(configuration);
  }

  @Override
  public void onDraw(ProcessingCanvas canvas) {
    worldDescription.applyOn(canvas);
  }

  public static DescribeWorldPerFrameSketch create(ViewportDefinition viewport, VisualDescription worldDescription) {
    DescribeWorldPerFrameSketch sketch = new DescribeWorldPerFrameSketch();
    sketch.viewport = viewport;
    sketch.worldDescription = worldDescription;
    return sketch;
  }

}
