package ar.com.kfgodel.processingo.api.original;

/**
 * This type represents the implicit style options that processing uses when drawing visuals
 *
 * Created by tenpines on 04/11/15.
 */
public interface ProcessingStyle {
  /**
   * Defines the inner fill color to use for shapes
   * @param rgb The color definition
   * @see <a href="https://processing.org/reference/fill_.html">https://processing.org/reference/fill_.html</a>
   */
  void fill(int rgb);
}
