package ar.com.kfgodel.processingo.sketchs;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.input.MouseEventContext;
import ar.com.kfgodel.processingo.impl.sketchs.PluggableSketchSupport;
import org.junit.runner.RunWith;

import java.util.function.Consumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the base behavior of a pluggable sketch
 * Created by tenpines on 02/11/15.
 */
@RunWith(JavaSpecRunner.class)
public class PluggableSketchTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a pluggable support", () -> {
      context().pluggable(PluggableSketchSupport::new);

      it("can delegate its mouse click to a function", () -> {
        Consumer<MouseEventContext> function = mock(Consumer.class);
        context().pluggable().plugOnMouseClicked(function);

        MouseEventContext mouseEvent = mock(MouseEventContext.class);
        context().pluggable().onMouseClicked(mouseEvent);

        verify(function).accept(mouseEvent);
      });
    });
  }
}
