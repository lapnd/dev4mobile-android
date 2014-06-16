package cn.dev4mob.app.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.dev4mob.app.R;
import timber.log.Timber;

public class OtherSpotlightActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test_layout);

    ImageView spotlight = (ImageView) findViewById(R.id.image_button);
    final FrameLayout container = (FrameLayout) findViewById(R.id.container);
    final float scale = 1.0f;
    DisplayMetrics dm = getResources().getDisplayMetrics();

    final int screenWidth = dm.widthPixels;
    final int screenHeight = dm.heightPixels;

    spotlight.setOnClickListener(new View.OnClickListener(){

      @Override public void onClick(View v) {
        Timber.d("onClickListener");
        int height = container.getHeight();

        Timber.d("height = %d", height);
        int width = container.getWidth();
        Timber.d("width = %d", width);


        Timber.d("screenWidth = %d", screenWidth);
        Timber.d("screenHeight = %d", screenHeight);
        int scale = screenHeight;
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(container,
            "scaleY", scale);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(container,
            "scaleX", scale);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        anim1.setDuration(1500);
        anim2.setDuration(1500);
        anim1.setInterpolator(new AccelerateInterpolator());
        animSet.start();
      }
    });
  }
}
