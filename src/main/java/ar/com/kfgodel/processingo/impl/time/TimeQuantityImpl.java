package ar.com.kfgodel.processingo.impl.time;

import ar.com.kfgodel.processingo.api.time.TimeQuantity;

import java.util.concurrent.TimeUnit;

/**
 * Implementation of time quantity
 * Created by tenpines on 31/10/15.
 */
public class TimeQuantityImpl implements TimeQuantity {

  private int amount;
  private TimeUnit unit;

  @Override
  public int amount() {
    return amount;
  }

  @Override
  public TimeUnit unit() {
    return unit;
  }

  public static TimeQuantityImpl create(int amount, TimeUnit unit) {
    TimeQuantityImpl quantity = new TimeQuantityImpl();
    quantity.amount = amount;
    quantity.unit = unit;
    return quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TimeQuantity)) return false;

    TimeQuantity that = (TimeQuantity) o;

    if (amount != that.amount()) return false;
    return unit == that.unit();

  }

  @Override
  public int hashCode() {
    int result = amount;
    result = 31 * result + (unit != null ? unit.hashCode() : 0);
    return result;
  }
}
