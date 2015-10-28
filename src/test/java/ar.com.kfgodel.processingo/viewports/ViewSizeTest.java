package ar.com.kfgodel.processingo.viewports;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.viewports.ViewSize;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies the behavior of a view size
 * Created by tenpines on 27/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class ViewSizeTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a view size", ()->{
      context().viewSize(()-> ViewSize.of(200, 100));

      it("has a width",()->{
        assertThat(context().viewSize().width()).isEqualTo(200);
      });

      it("has a height", ()->{
        assertThat(context().viewSize().height()).isEqualTo(100);
      });
    });
  }
}
