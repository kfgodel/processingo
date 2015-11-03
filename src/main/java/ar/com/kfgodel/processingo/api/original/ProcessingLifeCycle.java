package ar.com.kfgodel.processingo.api.original;

/**
 * This type represents the hooks that processing offers to be called under certain events
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingLifeCycle {

  /**
   * Called by processing before running the sketch code to setup the pixel environment.
   * Only a very few operations are allowed.<br>
   *   @see <a href="https://processing.org/reference/settings_.html">https://processing.org/reference/settings_.html</a>
   */
  void settings();

  /**
   * Called after the viewport sizing to define initial state for the sketch drawing (also to load resources)
   * @see <a href="https://processing.org/reference/setup_.html">https://processing.org/reference/setup_.html</a>
   */
  void setup();

  /**
   * Called each frame to change the contents of the viewport in order to update the fram
   * @see <a href="https://processing.org/reference/draw_.html">https://processing.org/reference/draw_.html</a>
   */
  void draw();
}
