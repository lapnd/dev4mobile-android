package cn.dev4mob.app.ui.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cn.dev4mob.app.R;
import timber.log.Timber;

public class MockActivityState extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mock_activity_state);
    Timber.d("onSaveInstanceState outState=%d", savedInstanceState == null ? 0 : 1);
    if (savedInstanceState != null) {
      Timber.d("onSaveInstanceState outState=%s", savedInstanceState.toString());
    }
    Timber.d("onCreate....");
  }

  @Override protected void onResume() {
    super.onResume();
    Timber.d("onResume");
  }


  @Override protected void onStart() {
    super.onStart();
    Timber.d("onStart");
  }

  //@Override protected void onSaveInstanceState(Bundle outState) {
  //  super.onSaveInstanceState(outState);
  //  Timber.d("onSaveInstanceState outState=%d", outState == null ? 0 : 1);
  //  if (outState != null) {
  //    Timber.d("onSaveInstanceState outState=%s", outState.toString());
  //  }
  //}

  @Override protected void onPause() {
    super.onPause();
    Timber.d("onPause");
  }

  @Override protected void onStop() {
    super.onStop();
    Timber.d("onStop");
  }


  @Override protected void onDestroy() {
    super.onDestroy();
    Timber.d("onResume");
  }




  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.mock_activity_state, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
