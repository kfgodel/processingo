package ar.com.kfgodel.processingo;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.api.original.ProcessingRenderer;
import org.junit.runner.RunWith;
import processing.core.PConstants;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of the renderer constants
 * Created by tenpines on 27/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class ProcessingRendererTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a processing renderer", ()->{
      it("maps to a processing renderer constant", ()->{
        assertThat(ProcessingRenderer.JAVA2D.constant()).isEqualTo(PConstants.JAVA2D);
        assertThat(ProcessingRenderer.P2D.constant()).isEqualTo(PConstants.P2D);
        assertThat(ProcessingRenderer.P3D.constant()).isEqualTo(PConstants.P3D);
        assertThat(ProcessingRenderer.PDF.constant()).isEqualTo(PConstants.PDF);
        assertThat(ProcessingRenderer.SVG.constant()).isEqualTo(PConstants.SVG);
        assertThat(ProcessingRenderer.DXF.constant()).isEqualTo(PConstants.DXF);
      });
    });
  }
}
