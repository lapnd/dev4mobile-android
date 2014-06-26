package cn.dev4mob.app.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle; import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dev4mob.app.R;
import cn.dev4mob.app.ui.activity.DrawerActivity;
import cn.dev4mob.app.ui.base.activity.AwesomeActivity;
import cn.dev4mob.app.ui.base.fragment.AwesomeFragment;
import cn.dev4mob.app.ui.base.fragment.ItemFragment;
import cn.dev4mob.app.utils.ScreenHelper;
import timber.log.Timber;

public class HomeActivity extends AwesomeActivity implements ItemFragment.OnFragmentInteractionListener {

  Fragment fragment;

  @InjectView(R.id.imageView) ImageView imageView;
  //@InjectView(R.id.text) TextView textView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_home);
    ////Timber.d("fragment=%d", fragment == null ? 0 : 1);
    //if (savedInstanceState == null) {
    //  Timber.d("savedInstanceState %s", "savedInstanceStatie");
    //  getFragmentManager().beginTransaction() .replace(R.id.content, new AwesomeFragment(), "awesomefragment").commit();
    //}else {
    //  Timber.d("savedInstanceState %s", savedInstanceState.toString());
    //  fragment = getFragmentManager().findFragmentByTag("awesomefragment");
    //  Timber.d("fragment=%d", fragment == null ? 0 : 1);
    //}

    //get("https://raw.github.com/square/okhttp/master/README.md");
    //post();
    //startActivity(new Intent(this, DrawerActivity.class));
    //startActivity(new Intent(this, PicassoActivity.class));
    //FlurryUtils.statistics("onCrate","username", "awesome");
    //setContentView(R.layout.sample_my_view);
    setContentView(R.layout.main);
    ButterKnife.inject(this);
  }

  //@OnClick(R.id.content)
  //public void click(LinearLayout view) {
  //  //AnimationSet set = new AnimationSet(false);
  //  //Animation scalanimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
  //  //imageView.startAnimation(scalanimation);
  //  //Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
  //  //textView.startAnimation(alphaAnimation);
  //  //set.addAnimation(scalanimation);
  //  //set.addAnimation(alphaAnimation);
  //  //set.start();
  //  //float width = linearLayout.getWidth();
  //  //if (linearLayout.getX() == 0 ) {
  //  //  ObjectAnimator translationRight = ObjectAnimator.ofFloat(linearLayout, "X", width);
  //  //  translationRight.setDuration(1500);
  //  //  translationRight.start();
  //  //} else {
  //  //
  //  //  ObjectAnimator translationLeft = ObjectAnimator.ofFloat(linearLayout, "X", 0f);
  //  //  translationLeft.setDuration(1500);
  //  //  translationLeft.start();
  //  //}
  //
  //
  //  float width = view.getWidth();
  //  float height = view.getHeight();
  //  ObjectAnimator translationRight = ObjectAnimator.ofFloat(view, "X", width);
  //  ObjectAnimator translationLeft = ObjectAnimator.ofFloat(view, "X", 0);
  //  ObjectAnimator translationDown = ObjectAnimator.ofFloat(view, "Y", view.getTop() + height);
  //  ObjectAnimator translationUp = ObjectAnimator.ofFloat(view, "Y", 0);
  //  AnimatorSet as = new AnimatorSet();
  //  as.play(translationRight).before(translationLeft);
  //  as.play(translationRight).with(translationDown);
  //  as.play(translationLeft).with(translationUp);
  //  as.setDuration(1500);
  //  as.start();
  //
  //}

  private  boolean flag = true;

  @OnClick(R.id.imageView)
  public void clickImageView(final ImageView imageView) {
    int width = ScreenHelper.getScreenWidth(this);
    int height = ScreenHelper.getScreenHeight(this);
    int imageSize = imageView.getWidth();
    int max = width;
    if (width < height) {
        max = height;
    }

    int scale = max /imageSize;
    Timber.d("max = %d", max);
    Timber.d("scale = %d", scale);
    if (flag) {
      ValueAnimator scaleAnimatorX = ObjectAnimator.ofFloat(imageView, View.SCALE_X, 1f, 1);
      ValueAnimator scaleAnimatorY = ObjectAnimator.ofFloat(imageView, View.SCALE_Y, 1f, 1);
      ValueAnimator alphaAnimator =  ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.3f, 1f);
      scaleAnimatorX.setDuration(3500);
      scaleAnimatorY.setDuration(3500);
      alphaAnimator.setDuration(3500);
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.setInterpolator(new DecelerateInterpolator());
      animatorSet.play(scaleAnimatorX).with(scaleAnimatorY).with(alphaAnimator);

      scaleAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          int value = (Integer)animation.getAnimatedValue();

        }
      });

      animatorSet.addListener(new AnimatorListenerAdapter() {
        @Override public void onAnimationEnd(Animator animation) {
          super.onAnimationEnd(animation);
          imageView.setAlpha(1f);
          flag = false;
        }
      });
      animatorSet.start();

    } else {
      ValueAnimator scaleAnimatorX = ObjectAnimator.ofFloat(imageView, View.SCALE_X, 1f, 1f);
      ValueAnimator scaleAnimatorY = ObjectAnimator.ofFloat(imageView, View.SCALE_Y, 1f, 1f);
      ValueAnimator alphaAnimator =  ObjectAnimator.ofFloat(imageView, View.ALPHA, 0.3f, 1f);
      scaleAnimatorX.setDuration(3500);
      scaleAnimatorY.setDuration(3500);
      alphaAnimator.setDuration(3500);
      AnimatorSet animatorSet = new AnimatorSet();
      animatorSet.setInterpolator(new OvershootInterpolator());
      animatorSet.play(scaleAnimatorX).with(scaleAnimatorY).with(alphaAnimator);
      animatorSet.addListener(new AnimatorListenerAdapter() {
        @Override public void onAnimationEnd(Animator animation) {
          super.onAnimationEnd(animation);
          imageView.setAlpha(1f);
          flag = true;
        }
      });
      animatorSet.start();
    }
  }


    //private void get(final String url) {
    //  new Thread(new Runnable() {
    //    @Override public void run() {
    //      OkHttpClient client = new OkHttpClient();
    //      Request request = new Request.Builder().url(url).build();
    //      Response response = null;
    //      try {
    //        response = client.newCall(request).execute();
    //        Timber.d("response= %s", response.body().string());
    //      } catch (IOException e) {
    //        Timber.e(e, "request url error= %s", e.getCause());
    //      }
    //    }
    //  }).start();
    //}
    //
    //private void post() {
    //  new Thread(new Runnable() {
    //    @Override public void run() {
    //      OkHttpClient client = new OkHttpClient();
    //      String json = bowlingJson("Jesse", "Jake");
    //      RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
    //      Request request = new Request.Builder().url("http://www.roundsapp.com/post").post(body).build();
    //      Response response = null;
    //      try {
    //        response = client.newCall(request).execute();
    //        int code = response.code();
    //        Timber.d("post response = %s code = %d", response.body().string(), code);
    //      } catch (IOException e) {
    //        Timber.e(e, "post error= %s", e.getLocalizedMessage());
    //      }
    //    }
    //  }).start();
    //}

  String bowlingJson(String player1, String player2) {

    return "{'winCondition':'HIGH_SCORE',"
        + "'name':'Bowling',"
        + "'round':4,"
        + "'lastSaved':1367702411696,"
        + "'dateStarted':1367702378785,"
        + "'players':["
        + "{'name':'"
        + player1
        + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
        + "{'name':'"
        + player2
        + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
        + "]}";
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.home, menu);
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

  @Override public void onFragmentInteraction(String id) {
  }
}
