package cn.dev4mob.app.ui.thread;

import timber.log.Timber;

/**
 * Created by dev4mobile on 6/2/14.
 */
public class ThreadJoin {

  public void test() throws InterruptedException {
    final Thread thread1 = new Thread(new Runnable() {
      @Override public void run() {
        Timber.d("thread1 = %s", Thread.currentThread());
      }
    });

    final Thread thread2 = new Thread(new Runnable() {
      @Override public void run() {
        Timber.d("thread2 = %s", Thread.currentThread());
      }
    });

    final Thread thread3 = new Thread(new Runnable() {
      @Override public void run() {
        Timber.d("thread3 = %s", Thread.currentThread());
      }
    });

    thread1.start();
    thread1.join();

    thread2.start();

    thread2.join();

    thread3.start();
    thread3.join();
  }

}
