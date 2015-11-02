package ar.com.kfgodel.processingo.worker.api;

/**
 * Exception used to represent problems with the worker thread
 * Created by tenpines on 01/11/15.
 */
public class WorkerException extends RuntimeException {

  public WorkerException(String message) {
    super(message);
  }

  public WorkerException(String message, Throwable cause) {
    super(message, cause);
  }

  public WorkerException(Throwable cause) {
    super(cause);
  }
}
