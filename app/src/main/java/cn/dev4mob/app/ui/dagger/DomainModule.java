package cn.dev4mob.app.ui.dagger;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by dev4mobile on 6/26/14.
 */

@Module(complete = false, library = true)
public class DomainModule {

  @Provides @Singleton public AnalyticsManager provideAnalyticsManager(Application app) {
    return new AnalyticsManager(app);
  }
}
