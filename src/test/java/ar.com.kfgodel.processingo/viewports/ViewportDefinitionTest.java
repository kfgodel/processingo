package ar.com.kfgodel.processingo.viewports;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingRenderer;
import ar.com.kfgodel.processingo.api.viewports.ViewSize;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This type verifies the behavior of viewport definitions
 * Created by tenpines on 27/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class ViewportDefinitionTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a viewport definition", () -> {

      describe("when a fixed size window is needed", () -> {
        it("configures processing to define the size and renderer of the window", () -> {
          ProcessingConfiguration processingConfig = mock(ProcessingConfiguration.class);

          ViewportDefinition definition = ViewportDefinition.window(ViewSize.of(80, 60), ProcessingRenderer.P2D);
          definition.change(processingConfig);

          verify(processingConfig).size(80, 60, ProcessingRenderer.P2D.constant());
        });

      });

      describe("when fullscreen is needed", ()->{
        it("configures processing to go fullscreen and use the given renderer", ()->{
          ProcessingConfiguration processingConfig = mock(ProcessingConfiguration.class);

          ViewportDefinition definition = ViewportDefinition.fullscreen(ProcessingRenderer.P2D);
          definition.change(processingConfig);

          verify(processingConfig).fullScreen(ProcessingRenderer.P2D.constant());
        });
      });

    });
  }
}
