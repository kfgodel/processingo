package ar.com.kfgodel.processingo.space;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This type verifies teh behavior of a 2d vector
 * Created by tenpines on 28/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class Vector2dTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a 2d vector", () -> {
      context().vector(() -> Vector2d.xy(20, 10));

      it("has a x component", () -> {
        assertThat(context().vector().x()).isEqualTo(20);
      });

      it("has a y component", () -> {
        assertThat(context().vector().y()).isEqualTo(10);
      });

    });
  }
}
