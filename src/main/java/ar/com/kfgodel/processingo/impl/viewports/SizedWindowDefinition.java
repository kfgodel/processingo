package ar.com.kfgodel.processingo.impl.viewports;

import ar.com.kfgodel.processingo.api.original.ProcessingConfiguration;
import ar.com.kfgodel.processingo.api.original.ProcessingRenderer;
import ar.com.kfgodel.processingo.api.viewports.ViewSize;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;

/**
 * Implementation of the viewport definition
 * Created by tenpines on 27/10/15.
 */
public class SizedWindowDefinition implements ViewportDefinition {

  private ViewSize size;
  private ProcessingRenderer renderer;

  @Override
  public void change(ProcessingConfiguration configuration) {
    configuration.size(size.width(), size.height(), renderer.constant());
  }

  public static SizedWindowDefinition create(ViewSize size, ProcessingRenderer renderer) {
    SizedWindowDefinition definition = new SizedWindowDefinition();
    definition.size = size;
    definition.renderer = renderer;
    return definition;
  }

}
