package cn.dev4mob.app.ui.prototypedesign;

import timber.log.Timber;

/**
 * Created by dev4mobile on 6/1/14.
 */
public class Concreate implements Prototype, Cloneable {

  private int x;

  public Concreate(int x) {
    this.x = x;
  }

  @Override public void setSize(int x) {
    this.x = x;
  }

  @Override public void printSize() {
    Timber.d("x = %d", x);
  }

  @Override protected Concreate clone() throws CloneNotSupportedException {
    return (Concreate)super.clone();
  }
}
