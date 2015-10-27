package ar.com.kfgodel.processingo.api;

/**
 * This type represents the execution
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingRunner {
  /**
   * Runs the given sketch to display its contents using processing
   * @param sketch The sketch that will be displayed
   */
  void run(ProcessingSketch sketch);
}
