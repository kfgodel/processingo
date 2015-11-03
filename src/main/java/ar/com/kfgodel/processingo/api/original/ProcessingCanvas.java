package ar.com.kfgodel.processingo.api.original;

/**
 * This type represents the visual space that can be drawn on.<br>
 *   It has all the methods that are used to draw or modify the canvas
 *
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingCanvas {
  /**
   * Draws a text string positioned under the indicated coordinates according to the current
   * positioning model.
   * @param text The string to display
   * @param x The x coordinate of the reference point
   * @param y The y coordinate of the reference point
   * @see <a href="https://processing.org/reference/text_.html">https://processing.org/reference/text_.html</a>
   */
  void text(String text, float x, float y);

  /**
   * Draws an ellipse or circle depending on the width and height, positioned using the current positioning mode
   * @param x The x coordinate of the reference point
   * @param y The y coordinate of the reference point
   * @param width The width of the ellipse
   * @param height The height of the ellipse
   * @see <a href="https://processing.org/reference/ellipse_.html">https://processing.org/reference/ellipse_.html</a>
   */
  void ellipse(float x, float y, float width, float height);

  /**
   * Redraws the viewport using a color
   * @param rgb The color to use
   * @see <a href="https://processing.org/reference/background_.html">https://processing.org/reference/background_.html</a>
   */
  void background(int rgb);
}
