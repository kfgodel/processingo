package ar.com.kfgodel.processingo.impl.viewports;

import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingRenderer;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;

/**
 * This type represents a fullscreen viewport definition
 * Created by tenpines on 27/10/15.
 */
public class FullscreenDefinition implements ViewportDefinition {

  private ProcessingRenderer renderer;

  @Override
  public void change(ProcessingConfiguration configuration) {
    configuration.fullScreen(renderer.constant());
  }

  public static FullscreenDefinition create(ProcessingRenderer renderer){
      FullscreenDefinition definition = new FullscreenDefinition();
      definition.renderer = renderer;
      return definition;
  }

}
