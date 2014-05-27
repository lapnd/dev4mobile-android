package cn.dev4mob.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cn.dev4mob.app.R;
import cn.dev4mob.app.ui.activity.PicassoActivity;
import cn.dev4mob.app.ui.base.activity.AwesomeActivity;
import cn.dev4mob.app.ui.base.fragment.AwesomeFragment;
import cn.dev4mob.app.ui.base.fragment.ItemFragment;

public class HomeActivity extends AwesomeActivity
    implements ItemFragment.OnFragmentInteractionListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    getFragmentManager().beginTransaction()
        .replace(R.id.content, new AwesomeFragment())
        .commitAllowingStateLoss();
    //get("https://raw.github.com/square/okhttp/master/README.md");
    //post();
    //startActivity(new Intent(this, DrawerActivity.class));
    startActivity(new Intent(this, PicassoActivity.class));
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
        + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
        + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
        + "]}";
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.home, menu);
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
