package cn.dev4mob.app.utils;

import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev4mobile on 6/5/14.
 */
public class FlurryUtils {

  public static void statistics(String tag, String key, String value) {
    Map<String, String> map = new HashMap<String, String>();
    map.put(key, value);
    FlurryAgent.onEvent(tag, map);
  }
}
