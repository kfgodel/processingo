package ar.com.kfgodel.processingo.api.input;

/**
 * This type represents a mouse event for a sketch providing access to the processing context if needed
 *
 * Created by tenpines on 02/11/15.
 */
public interface MouseEventContext {

  /**
   * @return X coordinate of the mouse when the event happened
   */
  float mouseX();

  /**
   * @return Y coordinate of the mouse when the event happened
   */
  float mouseY();
}
