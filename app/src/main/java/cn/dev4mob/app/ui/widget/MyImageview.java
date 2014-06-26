package cn.dev4mob.app.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.dev4mob.app.R;
import timber.log.Timber;

/**
 * Created by dev4mobile on 6/19/14.
 */
public class MyImageview extends ImageView {
  public MyImageview(Context context) {
    this(context, null);
  }

  public MyImageview(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public MyImageview(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    int width = getWidth();
    int height = getHeight();
    int left = getLeft();
    int top = getTop();
    Timber.d("width = %d", width);
    Timber.d("height = %d", height);
    Timber.d("left = %d", left);
    Timber.d("top = %d", top);

    //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
    //    R.drawable.circle_shape);
    Paint paint = new Paint();
    //canvas.drawBitmap(bitmap,left -50, top -50, paint);
    paint.setColor(0xFF0000);
    canvas.drawCircle(left + width / 2, height/ 2 + top, 1024, paint);
  }
}
