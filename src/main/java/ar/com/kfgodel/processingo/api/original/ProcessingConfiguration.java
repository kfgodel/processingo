package ar.com.kfgodel.processingo.api.original;

/**
 * This type represents the configuration options that processing offers to adjust the sketch settings
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingConfiguration {
  /**
   * Defines the configuration of the view port by setting a size and
   * a renderer type
   * @param width The width of the viewport in pixels
   * @param height The height of the viewport in pixels
   * @param renderer one of the possible renderer constants
   * @see <a href="https://processing.org/reference/size_.html">https://processing.org/reference/size_.html</a>
   */
  void size(int width, int height, String renderer);

  /**
   * Configures the view to use the fullscreen size (whatever that is)
   * @param renderer The renderer to use in the viewport
   * @see <a href="https://processing.org/reference/fullScreen_.html">https://processing.org/reference/fullScreen_.html</a>
   */
  void fullScreen(String renderer);

}
