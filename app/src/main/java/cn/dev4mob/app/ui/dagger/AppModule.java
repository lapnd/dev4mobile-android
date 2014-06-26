package cn.dev4mob.app.ui.dagger;

import android.app.Application;
import cn.dev4mob.app.AwesomeApp;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dev4mobile on 6/26/14.
 */
@Module(injects = {AwesomeApp.class}, includes = {DomainModule.class})
public class AppModule {
  private AwesomeApp app;

  public AppModule(AwesomeApp app) {
    this.app = app;
  }

  @Provides public Application provideApplicationContext() {
    return app;
  }

}
