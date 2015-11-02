package ar.com.kfgodel.processingo.worker.api;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.impl.PeriodicTaskImpl;

/**
 * This type represents a unit of work for a worker thread. <br>
 *   When executed this instance can access the
 * Created by tenpines on 31/10/15.
 */
@FunctionalInterface
public interface WorkerTask {
  /**
   * Invoked by the worker thread under its own thread, to solve this task.<br>
   *   The worker is passed as argument to allow the task adding more work to do
   * @param worker The current executor worker thread
   */
  void execute(WorkerThread worker);

  /**
   * Creates a periodic task to execute a runnable code with a delay between executions
   * @param period The time wo wait before executions
   * @param code The code to run
   * @return The created periodic task
   */
  static PeriodicTask periodicWith(TimeQuantity period, Runnable code) {
    return PeriodicTaskImpl.create(period, code);
  }
}
