package ar.com.kfgodel.processingo.visuals;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.impl.visuals.BackgroundVisual;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the behavior of a colored background
 * Created by tenpines on 30/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class BackgroundVisualTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a background visual", () -> {
      context().visualDescription(()-> BackgroundVisual.create(4));

      it("draws a complete background", () -> {
        ProcessingCanvas canvas = mock(ProcessingCanvas.class);

        context().visualDescription().applyOn(canvas);

        verify(canvas).background(4);
      });
    });
  }
}
