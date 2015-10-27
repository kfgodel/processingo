package ar.com.kfgodel.processingo;

import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.original.ProcessingHooks;
import ar.com.kfgodel.processingo.impl.PappletAdapter;

import java.util.function.Supplier;

/**
 * Defines shared context for processing tests
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingoTestContext extends TestContext{
  PappletAdapter adapter();
  void adapter(Supplier<PappletAdapter> definition);

  ProcessingHooks hooks();
  void hooks(Supplier<ProcessingHooks> definition);

  ProcessingSketch sketch();
  void sketch(Supplier<ProcessingSketch> definition);
}
