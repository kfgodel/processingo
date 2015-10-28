package ar.com.kfgodel.processingo.impl;

import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.original.ProcessingSetup;

/**
 * This type serves as a base class for sketches that want to define just one part
 * of the sketch contract, inheriting default implementations for the rest
 *
 * Created by tenpines on 26/10/15.
 */
public class SketchSupport implements ProcessingSketch {

  @Override
  public void onSettings(ProcessingConfiguration configuration) {
    // Do nothing by default
  }

  @Override
  public void onSetup(ProcessingSetup processingSetup) {
    // Do nothing by default
  }
}
