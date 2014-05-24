package cn.dev4mob.app.ui.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import timber.log.Timber;

/**
 * Created by dev4mobile on 5/24/14.
 */
public class AwesomeActivity extends Activity {
  private static final boolean debug = true;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (debug) Timber.d("onKeyDown %d", keyCode);
    return super.onKeyDown(keyCode, event);
  }
}
