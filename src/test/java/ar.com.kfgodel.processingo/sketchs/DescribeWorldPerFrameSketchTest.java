package ar.com.kfgodel.processingo.sketchs;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;
import ar.com.kfgodel.processingo.impl.sketchs.DescribeWorldPerFrameSketch;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the behavior of the sketch that draws the world per every frame
 * Created by tenpines on 28/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class DescribeWorldPerFrameSketchTest extends JavaSpec<ProcessingoTestContext>{
  @Override
  public void define() {
    describe("a describe world per frame sketch", () -> {

      context().sketch(()-> DescribeWorldPerFrameSketch.create(context().viewport(), context().visualDescription()));
      context().visualDescription(() -> mock(VisualDescription.class));
      context().viewport(()-> mock(ViewportDefinition.class));

      it("uses the given viewport to setup the display when called to onSettings", () -> {
        ProcessingConfiguration givenConfiguration = mock(ProcessingConfiguration.class);

        context().sketch().onSettings(givenConfiguration);

        verify(context().viewport()).change(givenConfiguration);
      });
      it("uses the given visual description to draw the world when draw is called", () -> {
        ProcessingCanvas givenCanvas = mock(ProcessingCanvas.class);

        context().sketch().onDraw(givenCanvas);

        verify(context().visualDescription()).applyOn(givenCanvas);
      });
    });
  }
}
