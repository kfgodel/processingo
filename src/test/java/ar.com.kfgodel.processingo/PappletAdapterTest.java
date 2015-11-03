package ar.com.kfgodel.processingo;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.input.MouseEventContext;
import ar.com.kfgodel.processingo.api.original.ProcessingCanvas;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingSetup;
import ar.com.kfgodel.processingo.impl.PappletAdapter;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type tests the behavior for processing applet adapter
 *
 * Created by tenpines on 26/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class PappletAdapterTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("an applet adapter", ()->{
      context().adapter(() -> PappletAdapter.create(context().sketch()));

      describe("as a life cycle", ()->{
        context().lifeCycle(() -> context().adapter());

        it("delegates configuration to the sketch when settings is invoked", ()->{
          context().sketch(() -> mock(ProcessingSketch.class));

          context().lifeCycle().settings();

          verify(context().sketch()).onSettings(notNull(ProcessingConfiguration.class));
        });

        it("delegates setup to the sketch when setup is invoked", () -> {
          context().sketch(() -> mock(ProcessingSketch.class));

          context().lifeCycle().setup();

          verify(context().sketch()).onSetup(notNull(ProcessingSetup.class));
        });

        it("delegates draw to the sketch when draw is invoked", () -> {
          context().sketch(() -> mock(ProcessingSketch.class));

          context().lifeCycle().draw();

          verify(context().sketch()).onDraw(notNull(ProcessingCanvas.class));
        });
      });

      describe("as mouse listener", () -> {
        context().mouseEvents(() -> context().adapter());

        it("delegates mouse clicks to the sketch when mouseClicked is invoked", ()->{
          context().sketch(() -> mock(ProcessingSketch.class));

          context().mouseEvents().mouseClicked();

          verify(context().sketch()).onMouseClicked(notNull(MouseEventContext.class));
        });

      });

    });
  }
}
