package cn.dev4mob.app.ui.prototypedesign;

/**
 * Created by dev4mobile on 6/1/14.
 */
public class TestPrototype {

  public void test() throws CloneNotSupportedException {
    Concreate concreate = new Concreate(1);
    for (int i = 0; i < 10; i++) {
      Concreate concreate1 = concreate.clone();
      concreate1.setSize(20 + i);
      concreate1.printSize();
    }
  }

}
