package ar.com.kfgodel.processingo.worker.impl;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.PeriodicTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;

/**
 * This type implements a periodic task
 * Created by tenpines on 31/10/15.
 */
public class PeriodicTaskImpl implements PeriodicTask {

  private TimeQuantity period;
  private Runnable taskCode;

  @Override
  public void execute(WorkerThread worker) {
    taskCode.run();
    worker.executeAfter(period, this);
  }

  public static PeriodicTaskImpl create(TimeQuantity period, Runnable taskCode) {
    PeriodicTaskImpl task = new PeriodicTaskImpl();
    task.period = period;
    task.taskCode = taskCode;
    return task;
  }

}
