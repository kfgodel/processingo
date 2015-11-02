package ar.com.kfgodel.processingo.worker.impl;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;
import ar.com.kfgodel.processingo.worker.impl.state.RunningWorkerState;
import ar.com.kfgodel.processingo.worker.impl.state.StoppedWorkerState;

/**
 * This type implements a worker thread
 * Created by tenpines on 31/10/15.
 */
public class WorkerThreadImpl implements WorkerThread {

  private WorkerThread state;

  @Override
  public void executeAfter(TimeQuantity delayQuantity, WorkerTask task) {
    state.executeAfter(delayQuantity, task);
  }

  @Override
  public void execute(WorkerTask task) {
    state.execute(task);
  }

  @Override
  public void stopWork() {
    state.stopWork();
    state = StoppedWorkerState.create();
  }

  public static WorkerThreadImpl create() {
    WorkerThreadImpl thread = new WorkerThreadImpl();
    thread.state = RunningWorkerState.create(thread);
    return thread;
  }

}
