package cn.dev4mob.app.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.dev4mob.app.R;
import com.squareup.picasso.Picasso;

public class PicassoActivity extends Activity {

  @InjectView(R.id.imageview) ImageView mImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_picasso);
    ButterKnife.inject(this);
    //new Thread(new Runnable() {
    //  @Override public void run() {
    //    Picasso.with(PicassoActivity.this).load("http://i.imgur.com/DvpvklR.png").into(mImageView);
    //  }
    //}).start();
    Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").placeholder(R.drawable.ic_drawer).resize(170, 270).into(mImageView);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.picasso, menu);
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
