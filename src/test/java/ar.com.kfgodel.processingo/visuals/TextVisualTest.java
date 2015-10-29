package ar.com.kfgodel.processingo.visuals;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import ar.com.kfgodel.processingo.impl.visuals.TextVisual;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the behavior of a text visual description
 * Created by tenpines on 28/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class TextVisualTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a text visual", () -> {
      context().visualDescription(()-> TextVisual.create("a text", Vector2d.xy(1, 2)));

      it("draws a text when applied on a processing canvas", () -> {
        ProcessingCanvas canvas = mock(ProcessingCanvas.class);

        context().visualDescription().applyOn(canvas);

        verify(canvas).text("a text", 1, 2);
      });
    });
  }
}
