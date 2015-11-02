package ar.com.kfgodel.processingo.worker.impl.state;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

/**
 * This type represents a worker that is currently running
 * <p>
 * Created by tenpines on 01/11/15.
 */
public class RunningWorkerState extends Thread implements WorkerThread {

  private ScheduledExecutorService delayExecutor;
  private BlockingQueue<WorkerTask> externalQueue;
  private boolean running;
  private WorkerThread workerSelf;

  @Override
  public void executeAfter(TimeQuantity delayQuantity, WorkerTask task) {
    delayExecutor.schedule(() -> execute(task), delayQuantity.amount(), delayQuantity.unit());
  }

  @Override
  public void execute(WorkerTask task) {
    externalQueue.add(task);
  }

  @Override
  public void run() {
    while(running){
      try {
        processNextTasks();
      } catch (InterruptedException e) {
        // This is how other thread stop us, the exception is thrown while waiting more tasks
        running = false;
      }
    }
  }

  private void processNextTasks() throws InterruptedException {
    List<WorkerTask> nextTasks = blockWaitingForTasks();
    for (WorkerTask nextTask : nextTasks) {
      nextTask.execute(workerSelf);
    }
  }

  private List<WorkerTask> blockWaitingForTasks() throws InterruptedException {
    List<WorkerTask> nextTasks = new ArrayList<>();
    // This will block the thread until a task is available
    WorkerTask firstTask = externalQueue.take();
    nextTasks.add(firstTask);
    // Also, get all the available tasks without waiting
    externalQueue.drainTo(nextTasks);
    return nextTasks;
  }

  @Override
  public void stopWork() {
    delayExecutor.shutdown();
    this.interrupt();
  }

  public static RunningWorkerState create(WorkerThread workerSelf) {
    RunningWorkerState worker = new RunningWorkerState();
    worker.delayExecutor = Executors.newScheduledThreadPool(1);
    worker.externalQueue = new LinkedBlockingQueue<>();
    worker.running = true;
    worker.workerSelf = workerSelf;
    worker.start();
    return worker;
  }

}
