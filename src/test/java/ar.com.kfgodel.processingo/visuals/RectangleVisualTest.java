package ar.com.kfgodel.processingo.visuals;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.mathe.api.Mathe;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.impl.visuals.RectangleVisual;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Verifies the behavior of a rectangle visual
 * Created by tenpines on 04/11/15.
 */
@RunWith(JavaSpecRunner.class)
public class RectangleVisualTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a rectangle visual", () -> {
      context().visualDescription(() -> RectangleVisual.create(Mathe.vector(3, 4), Mathe.vector(50, 60)));

      it("draws a rectangle when applied on a processing canvas", () -> {
        ProcessingCanvas canvas = mock(ProcessingCanvas.class);

        context().visualDescription().applyOn(canvas);

        verify(canvas).rect(3, 4, 50, 60);
      });

    });
  }
}
