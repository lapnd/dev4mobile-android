package cn.dev4mob.app;

import android.app.Application;
import cn.dev4mob.app.ui.dagger.AnalyticsManager;
import cn.dev4mob.app.ui.dagger.AppModule;
import dagger.ObjectGraph;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

import static timber.log.Timber.DebugTree;

/**
 * Created by dev4mobile on 5/24/14.
 */
public class AwesomeApp extends Application {

  private ObjectGraph objectGraph;
  @Inject AnalyticsManager analyticsManager;

  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    } else {
      Timber.plant(new CrashReportingTree());
    }
    // start Fragment logging
    //FragmentManager.enableDebugLogging(true);

    //NewRelic.withApplicationToken("AAa52803e06a8d68f2a294649452d184f28e91d702").start(this.getApplication());

    objectGraph = ObjectGraph.create(getModules().toArray());
    objectGraph.inject(this);
    analyticsManager.registerAppEnter();
  }

  private List<Object> getModules() {
    return Arrays.<Object> asList(new AppModule(this));
  }


  /** A tree which logs important information for crash reporting. */
  private static class CrashReportingTree extends Timber.HollowTree {
    @Override public void i(String message, Object... args) {
      // TODO e.g., Crashlytics.log(String.format(message, args));
    }

    @Override public void i(Throwable t, String message, Object... args) {
      i(message, args); // Just add to the log.
    }

    @Override public void e(String message, Object... args) {
      i("ERROR: " + message, args); // Just add to the log.
    }

    @Override public void e(Throwable t, String message, Object... args) {
      e(message, args);

      // TODO e.g., Crashlytics.logException(t);
    }
  }
}
