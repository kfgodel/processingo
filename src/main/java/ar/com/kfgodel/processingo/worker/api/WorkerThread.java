package ar.com.kfgodel.processingo.worker.api;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.impl.WorkerThreadImpl;

/**
 * This type represents a thread that executes one task after the other, waiting for more tasks to arrive. <br>
 *   Other threads can add tasks to this worker as WorkerTask objects.<br>
 *
 * Created by tenpines on 31/10/15.
 */
public interface WorkerThread {
  /**
   * Creates a new worker thread instance
   */
  static WorkerThread create() {
    return WorkerThreadImpl.create();
  }

  /**
   * Executes the given task waiting the indicated delay before doing it
   * @param delayQuantity The time delay to wait before task execution
   * @param task The task to execute
   */
  void executeAfter(TimeQuantity delayQuantity, WorkerTask task);

  /**
   * Enqueues this task to be executed immediately. The worker thread will execute
   * the task when finished its current task
   * @param task The task to execute
   */
  void execute(WorkerTask task);

  /**
   * Stops the execution of this thread and the associated executor.<br>
   *   This is needed to release resources and prevent memory leaks
   */
  void stopWork();
}
