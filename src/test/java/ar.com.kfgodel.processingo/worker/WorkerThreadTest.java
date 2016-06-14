package ar.com.kfgodel.processingo.worker;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.WorkerException;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;
import org.junit.runner.RunWith;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.mock;

/**
 * This type verifies the behavior of a worker thread
 * Created by tenpines on 31/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class WorkerThreadTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a worker thread", () -> {
      context().worker(WorkerThread::create);

      // Need to free the worker resources after each test
      afterEach(()->{
        context().worker().stopWork();
      });

      it("executes the given task in a separate thread", () -> {
        CompletableFuture<Thread> threadThatExecutedTheTask = new CompletableFuture<>();

        WorkerTask task = (worker)->{
          Thread actualThread = Thread.currentThread();
          threadThatExecutedTheTask.complete(actualThread);
        };

        context().worker().execute(task);

        try {
          Thread currentThread = Thread.currentThread();
          Thread taskThread = threadThatExecutedTheTask.get(500, TimeUnit.MILLISECONDS);
          assertThat(taskThread).isNotEqualTo(currentThread);
        } catch (Exception e) {
          throw new RuntimeException("unexpected error", e);
        }
      });

      it("can execute a task with given delay", () -> {
        CompletableFuture<Long> executionMoment = new CompletableFuture<>();
        WorkerTask task = (worker) -> {
          executionMoment.complete(System.currentTimeMillis());
        };

        long startMoment = System.currentTimeMillis();
        context().worker().executeAfter(TimeQuantity.of(100,TimeUnit.MILLISECONDS), task);
        long elapsed = 0;
        try {
          elapsed = executionMoment.get(150, TimeUnit.MILLISECONDS) - startMoment;
        } catch (Exception e) {
          throw new RuntimeException("Unexpected error", e);
        }

        assertThat(elapsed).isGreaterThanOrEqualTo(100);
      });

      it("rejects new executions once stopped", () -> {
        context().worker().stopWork();

        try{
          context().worker().execute(mock(WorkerTask.class));
          failBecauseExceptionWasNotThrown(WorkerException.class);
        }catch(WorkerException e){
          assertThat(e).hasMessage("Cannot accept new tasks because worker is stopped");
        }

        try{
          context().worker().executeAfter(mock(TimeQuantity.class), mock(WorkerTask.class));
          failBecauseExceptionWasNotThrown(WorkerException.class);
        }catch(WorkerException e){
          assertThat(e).hasMessage("Cannot accept new tasks because worker is stopped");
        }
      });
    });
  }
}
