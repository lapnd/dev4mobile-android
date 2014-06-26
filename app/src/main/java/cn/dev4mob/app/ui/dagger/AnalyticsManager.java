package cn.dev4mob.app.ui.dagger;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by dev4mobile on 6/26/14.
 */
public class AnalyticsManager {

  private Application app;

  public AnalyticsManager(Application app) {
    this.app = app;
  }

  public void registerAppEnter() {
    Toast.makeText(app, "App enter", Toast.LENGTH_LONG).show();
  }

}
