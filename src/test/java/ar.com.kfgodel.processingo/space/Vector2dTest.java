package ar.com.kfgodel.processingo.space;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import org.assertj.core.data.Offset;
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

      it("returns a new vector as the result of the addition to other vector", () -> {
        Vector2d result = context().vector().plus(Vector2d.xy(10, 10));
        assertThat(result).isNotSameAs(context().vector());
        assertThat(result.x()).isEqualTo(context().vector().x() + 10);
        assertThat(result.y()).isEqualTo(context().vector().y() + 10);
      });

      it("returns a new vector when inverted x", () -> {
        Vector2d newVector = context().vector().invertX();
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(-1 * context().vector().x());
      });

      it("returns a new vector when inverted y", () -> {
        Vector2d newVector = context().vector().invertY();
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.y()).isEqualTo(-1 * context().vector().y());
      });

      it("returns a new elementProduct vector when multiplied", () -> {
        Vector2d other = Vector2d.xy(2.0, 3.0);
        Vector2d newVector = context().vector().elementProduct(other);
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(context().vector().x() * other.x());
        assertThat(newVector.y()).isEqualTo(context().vector().y() * other.y());
      });

      it("returns a new scaled vector when multiplied", () -> {
        Vector2d newVector = context().vector().scale(0.5);
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(10);
        assertThat(newVector.y()).isEqualTo(5);
      });

      it("returns the floor vector when integered", () -> {
        Vector2d newVector = Vector2d.xy(1.3, -1.8).integered();
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(1);
        assertThat(newVector.y()).isEqualTo(-1);
      });

      it("returns the new matrix product result when matrix product used", () -> {
        Vector2d newVector = Vector2d.xy(1,0).rotate(90);
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(0, Offset.offset(0.00000001f));
        assertThat(newVector.y()).isEqualTo(1);
      });

      it("returns the sign inverted vector when invert used", () -> {
        Vector2d newVector = context().vector().invert();
        assertThat(newVector).isNotSameAs(context().vector());
        assertThat(newVector.x()).isEqualTo(-20);
        assertThat(newVector.y()).isEqualTo(-10);
      });

    });
  }
}
