package cn.dev4mob.app.ui.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import butterknife.ButterKnife;
import cn.dev4mob.app.R;
import timber.log.Timber;

/**
 * Created by dev4mobile on 6/17/14.
 */
public class TestScaleActivity extends Activity{

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_scale_activity);
    final ImageView imageView = ButterKnife.findById(this, R.id.imageview);
    final View conatiner = ButterKnife.findById(this, R.id.container);
    imageView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Rect startRect = new Rect();
        Rect globalRect = new Rect();
        imageView.getGlobalVisibleRect(startRect);
        Timber.d("startRect = %s", startRect);
        conatiner.getGlobalVisibleRect(globalRect);
        Timber.d("globalRect = %s", globalRect);
      }
    });
  }
}
