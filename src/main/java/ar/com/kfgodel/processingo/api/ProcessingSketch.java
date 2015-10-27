package ar.com.kfgodel.processingo.api;

import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;

/**
 * This type represents the user code of a processing application.<br>
 *   The sketch represents what the user wants processing to do when running
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingSketch {
  /**
   * Called when the sketch is initialized to define aditional configuration
   * for the rendering settings
   * @param configuration The configuration that can be changed before starting the actual display
   */
  void onSettings(ProcessingConfiguration configuration);
}
