package ar.com.kfgodel.processingo.api.original;

/**
 * This type represents the hooks that processing offers to be called under certain events
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingHooks {

  /**
   * Called by processing before running the sketch code to setup the pixel environment.
   * Only a very few operations are allowed.<br>
   *   @see <a href="https://processing.org/reference/settings_.html">https://processing.org/reference/settings_.html</a>
   */
  void settings();
}
