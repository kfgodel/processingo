package ar.com.kfgodel.processingo.worker;

import ar.com.dgarcia.javaspec.api.JavaSpec;
import ar.com.dgarcia.javaspec.api.JavaSpecRunner;
import ar.com.kfgodel.processingo.ProcessingoTestContext;
import ar.com.kfgodel.processingo.api.time.TimeQuantity;
import ar.com.kfgodel.processingo.worker.api.WorkerTask;
import ar.com.kfgodel.processingo.worker.api.WorkerThread;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by tenpines on 31/10/15.
 */
@RunWith(JavaSpecRunner.class)
public class WorkerTaskTest extends JavaSpec<ProcessingoTestContext> {
  @Override
  public void define() {
    describe("a worker task", () -> {
      describe("created as a periodic task", () -> {
        context().task(()-> WorkerTask.periodicWith(TimeQuantity.of(1, TimeUnit.DAYS), context().runnable()));
        context().runnable(()-> mock(Runnable.class));

        it("executes the runnable code when executed", () -> {
          context().task().execute(mock(WorkerThread.class));

          verify(context().runnable()).run();
        });

        it("schedules itself to be run after the period", () -> {
          WorkerThread worker = mock(WorkerThread.class);

          context().task().execute(worker);

          verify(worker).executeAfter(TimeQuantity.of(1, TimeUnit.DAYS), context().task());
        });

      });
    });
  }
}
