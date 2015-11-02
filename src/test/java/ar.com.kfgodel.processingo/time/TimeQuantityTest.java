package ar.com.kfgodel.processingo.time;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Verifies the behavior of a time quantity
 * Created by tenpines on 31/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class TimeQuantityTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a time quantity", () -> {
      context().quantity(() -> TimeQuantity.of(3, TimeUnit.DAYS));

      it("has an amount", () -> {
        assertThat(context().quantity().amount()).isEqualTo(3);
      });
      it("has a unit", () -> {
        assertThat(context().quantity().unit()).isEqualTo(TimeUnit.DAYS);
      });
    });
  }
}
