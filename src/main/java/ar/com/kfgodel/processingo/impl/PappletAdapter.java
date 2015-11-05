package ar.com.kfgodel.processingo.impl;

import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.input.MouseEventContext;
import ar.com.kfgodel.processingo.api.original.*;
import processing.core.PApplet;

/**
 * This type serves as an adapter from processing original class inheritance model
 * to an instance delegation based.<br>
 *   The implementation overrides methods called by processing as hooks to delegate them to
 *   a delegate object, which instead of extending a class needs to implement an interface.
 *
 * Created by tenpines on 26/10/15.
 */
public class PappletAdapter extends PApplet
  implements ProcessingCanvas, ProcessingConfiguration, ProcessingLifeCycle, ProcessingSetup,
    ProcessingMouseEvents, MouseEventContext, ProcessingStyle {
  /**
   * Static variable used to reference the delegate sketch when
   * the instance of this class is created by processing
   */
  private static ProcessingSketch delegateSketchOnceCreated;

  /**
   * Executes this adapter as a processing application using the given sketch as a delegate
   * to handle the actual behavior.<br>
   * @param sketch The sketch to use as delegate
   */
  public static void execute(ProcessingSketch sketch) {
    // Because it's processing that instances us, we need to prepare the sketch to be grabbed once the instance is created
    delegateSketchOnceCreated = sketch;
    main(PappletAdapter.class.getName());
  }

  private ProcessingSketch delegateSketch;

  /**
   * Factory method for testing purposes.<br>
   *   Processing doesn't use this
   */
  public static PappletAdapter create(ProcessingSketch sketch){
      PappletAdapter adapter = new PappletAdapter();
      adapter.delegateSketch = sketch;
      return adapter;
  }

  /**
   * Creates an instance reference to the delegate sketch so it can be used
   * directly by the rest of the methods.<br>
   *   This needs to be called before anything else
   */
  private void grabDelegateSketch() {
    if(delegateSketch == null){
      // Only if it's not previously defined (usually on tests)
      delegateSketch = delegateSketchOnceCreated;
    }
  }

  @Override
  public void settings() {
    grabDelegateSketch();
    delegateSketch.onSettings(this);
  }

  @Override
  public void setup() {
    delegateSketch.onSetup(this);
  }

  @Override
  public void draw() {
    delegateSketch.onDraw(this);
  }

  @Override
  public void mouseClicked() {
    delegateSketch.onMouseClicked(this);
  }

  @Override
  public float mouseX() {
    return mouseX;
  }

  @Override
  public float mouseY() {
    return mouseY;
  }

}
