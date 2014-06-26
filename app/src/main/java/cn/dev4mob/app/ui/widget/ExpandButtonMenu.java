package cn.dev4mob.app.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by dev4mobile on 6/21/14.
 */
public class ExpandButtonMenu extends RelativeLayout {

  public ExpandButtonMenu(Context context) {
   this(context, null);
  }

  public ExpandButtonMenu(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ExpandButtonMenu(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

  }
}
