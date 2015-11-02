package ar.com.kfgodel.processingo.worker.impl.state;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.WorkerException;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;

/**
 * This type represents a worker in a stopped state.<br>
 * Created by tenpines on 01/11/15.
 */
public class StoppedWorkerState implements WorkerThread {

  @Override
  public void executeAfter(TimeQuantity delayQuantity, WorkerTask task) {
    throw new WorkerException("Cannot accept new tasks because worker is stopped");
  }

  @Override
  public void execute(WorkerTask task) {
    throw new WorkerException("Cannot accept new tasks because worker is stopped");
  }

  @Override
  public void stopWork() {
    // No problem on being executed more than once
  }

  public static StoppedWorkerState create() {
    StoppedWorkerState worker = new StoppedWorkerState();
    return worker;
  }

}
