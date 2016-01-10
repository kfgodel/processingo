package ar.com.kfgodel.processingo.visuals;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.impl.visuals.EllipseVisual;
import org.junit.runner.RunWith;

import static ar.com.kfgodel.mathe.api.Mathe.vector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the ellipse behavior
 * Created by tenpines on 30/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class EllipseVisualTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("an ellipse visual", () -> {
      context().visualDescription(() -> EllipseVisual.create(vector(1, 2), vector(100, 200)));

      it("draws an ellipse when applied on a processing canvas", () -> {
        ProcessingCanvas canvas = mock(ProcessingCanvas.class);

        context().visualDescription().applyOn(canvas);

        verify(canvas).ellipse(1, 2, 100, 200);
      });
    });
  }
}
