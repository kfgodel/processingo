package ar.com.kfgodel.processingo;

import ar.com.dgarcia.javaspec.api.TestContext;
import ar.com.kfgodel.processingo.api.ProcessingSketch;
import ar.com.kfgodel.processingo.api.original.ProcessingLifeCycle;
import ar.com.kfgodel.processingo.api.original.ProcessingMouseEvents;
import ar.com.kfgodel.processingo.api.sketchs.PluggableSketch;
import ar.com.kfgodel.processingo.api.space.Vector2d;
import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.api.viewports.ViewSize;
import ar.com.kfgodel.processingo.api.viewports.ViewportDefinition;
import ar.com.kfgodel.processingo.api.visuals.VisualDescription;
import ar.com.kfgodel.processingo.impl.PappletAdapter;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;

import java.util.function.Supplier;

/**
 * Defines shared context for processing tests
 * Created by tenpines on 26/10/15.
 */
public interface ProcessingoTestContext extends TestContext{
  PappletAdapter adapter();
  void adapter(Supplier<PappletAdapter> definition);

  ProcessingLifeCycle lifeCycle();
  void lifeCycle(Supplier<ProcessingLifeCycle> definition);

  ProcessingMouseEvents mouseEvents();
  void mouseEvents(Supplier<ProcessingMouseEvents> definition);

  ProcessingSketch sketch();
  void sketch(Supplier<ProcessingSketch> definition);

  ViewSize viewSize();
  void viewSize(Supplier<ViewSize> definition);

  ViewportDefinition viewport();
  void viewport(Supplier<ViewportDefinition> definition);

  VisualDescription visualDescription();
  void visualDescription(Supplier<VisualDescription> definition);

  Vector2d vector();
  void vector(Supplier<Vector2d> definition);

  void quantity(Supplier<TimeQuantity> definition);
  TimeQuantity quantity();

  WorkerTask task();
  void task(Supplier<WorkerTask> definition);

  Runnable runnable();
  void runnable(Supplier<Runnable> definition);

  void worker(Supplier<WorkerThread> definition);
  WorkerThread worker();

  PluggableSketch pluggable();
  void pluggable(Supplier<PluggableSketch> definition);
}
