package ar.com.kfgodel.processingo.impl;

import ar.com.kfgodel.processingo.api.ProcessingRunner;
import ar.com.kfgodel.processingo.api.ProcessingSketch;

/**
 * This type runs sketches using the papplet subclass adapter
 *
 * Created by tenpines on 26/10/15.
 */
public class PappletRunner implements ProcessingRunner {

  public static PappletRunner create(){
      PappletRunner runner = new PappletRunner();
      return runner;
  }

  @Override
  public void run(ProcessingSketch sketch) {
    PappletAdapter.execute(sketch);
  }
}
