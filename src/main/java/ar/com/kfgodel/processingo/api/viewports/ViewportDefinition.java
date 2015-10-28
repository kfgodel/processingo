package ar.com.kfgodel.processingo.api.viewports;

import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingRenderer;
import ar.com.kfgodel.processingo.impl.viewports.FullscreenDefinition;
import ar.com.kfgodel.processingo.impl.viewports.SizedWindowDefinition;

/**
 * This type represents the definition of a viewport view and rendering mode to setup
 * the display viewport
 *
 * Created by tenpines on 27/10/15.
 */
public interface ViewportDefinition {


  /**
   * Defines a windowed viewport of the given size and using the given renderer
   * @param size The size of the viewport
   * @param renderer The renderer to use in the viewport
   * @return The created definition
   */
  static ViewportDefinition window(ViewSize size, ProcessingRenderer renderer) {
    return SizedWindowDefinition.create(size, renderer);
  }

  /**
   * Defines a fullscreen viewport using the given renderer
   * @param renderer The renderer to use in the viewport
   * @return The viewport definition
   */
  static ViewportDefinition fullscreen(ProcessingRenderer renderer) {
    return FullscreenDefinition.create(renderer);
  }

  /**
   * Changes given configuration to match this viewport definition
   * @param configuration The affected config
   */
  void change(ProcessingConfiguration configuration);
}
