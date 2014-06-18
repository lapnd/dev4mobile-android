package cn.dev4mob.app.ui.multilistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import cn.dev4mob.app.R;

public class MainActivity extends Activity {

  private ListView listView;
  private ListView subListView;
  private MyAdapter myAdapter;
  private SubAdapter subAdapter;

  String cities[][] = new String[][] {
      new String[] { "test1", "test2", "test3", "test4" },
      new String[] { "demo1", "demo2", "demo3", "demo4" }, new String[] { "xxx1", "xxx2", "xxx3" },
      new String[] { "yyy1", "yyy2", "yyy3" }, new String[] { "zzz1", "zzz2", "zzz3" },
  };
  String foods[] = new String[] { "ccc1", "ccc2", "ccc3", "ccc4", "ccc5" };
  int images[] = new int[] {
      R.drawable.ic_category_0, R.drawable.ic_category_10, R.drawable.ic_category_30,
      R.drawable.ic_category_20, R.drawable.ic_category_60
  };

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_bak);

    init();
    myAdapter = new MyAdapter(getApplicationContext(), foods, images);
    listView.setAdapter(myAdapter);

    selectDefult();

    listView.setOnItemClickListener(new OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        // TODO Auto-generated method stub
        final int location = position;
        myAdapter.setSelectedPosition(position);
        myAdapter.notifyDataSetInvalidated();
        subAdapter = new SubAdapter(getApplicationContext(), cities[position]);
        subListView.setAdapter(subAdapter);
        subListView.setOnItemClickListener(new OnItemClickListener() {

          @Override
          public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            // TODO Auto-generated method stub
            Toast.makeText(getApplicationContext(), cities[location][position], Toast.LENGTH_SHORT)
                .show();
            subAdapter = new SubAdapter(getApplicationContext(), cities[0]);
            subListView.setAdapter(subAdapter);
            subListView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), cities[location][position], Toast.LENGTH_SHORT)
                    .show();
              }
            });
          }
        });
      }
    });
  }

  private void init() {
    listView = (ListView) findViewById(R.id.listView);
    subListView = (ListView) findViewById(R.id.subListView);
  }

  private void selectDefult() {
    final int location = 0;
    myAdapter.setSelectedPosition(0);
    myAdapter.notifyDataSetInvalidated();

  }
}
