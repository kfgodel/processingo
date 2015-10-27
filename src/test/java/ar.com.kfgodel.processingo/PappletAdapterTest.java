package ar.com.kfgodel.processingo;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.ProcessingSketch;
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

      describe("seen as a set of hooks", ()->{
        context().hooks(()-> context().adapter());

        it("delegates configuration to the sketch when settings is invoked", ()->{
          context().sketch(() -> mock(ProcessingSketch.class));

          context().hooks().settings();

          verify(context().sketch()).onSettings(notNull(ProcessingConfiguration.class));
        });
      });

    });
  }
}
