package ar.com.kfgodel.processingo.api.time;

import ar.com.kfgodel.processingo.impl.time.TimeQuantityImpl;

import java.util.concurrent.TimeUnit;

/**
 * This type represents a time measure (number and unit)
 * Created by tenpines on 31/10/15.
 */
public interface TimeQuantity {
  static TimeQuantity of(int value, TimeUnit unit) {
    return TimeQuantityImpl.create(value, unit);
  }

  int amount();

  TimeUnit unit();
}
