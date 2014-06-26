package cn.dev4mob.app.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import cn.dev4mob.app.R;
import cn.dev4mob.app.utils.ScreenHelper;
import timber.log.Timber;

/**
 * Created by dev4mobile on 6/20/14.
 */
public class CustomImageButton extends ImageButton {

  private boolean mAdjustViewSize;
  private float mDimCount;
  private Dialog mDialog;
  private ExpandButtonMenu expandButtonMenu;

  public CustomImageButton(Context context) {
    this(context, null);
  }

  public CustomImageButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public CustomImageButton(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    Timber.d("CustomImageButton(Context context, AttributeSet attrs, int defStyle)");
    if (attrs != null) {
      TypedArray a =
          context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomImageButton, 0, 0);
      //TypedArray  b = context.obtainStyledAttributes(attrs, R.styleable.CustomImageButton, 0, 0);
      try {
        mAdjustViewSize = a.getBoolean(R.styleable.CustomImageButton_adjustViewSize, false);
        mDimCount = a.getFloat(R.styleable.CustomImageButton_dimCount, 0);
        Timber.d("AdjustViewSize=%s", Boolean.toString(mAdjustViewSize));
        Timber.d("DimCount=%s", Float.toString(mDimCount));
      } finally {
        a.recycle();
      }
    }
    init(attrs);
  }

  private void init(AttributeSet attrs) {
    mDialog = new Dialog(getContext(), android.R.style.Theme_Translucent_NoTitleBar);
    mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
    lp.dimAmount = mDimCount;
  }

  @Override protected void onDraw(Canvas canvas) {
    Timber.d("onDraw");
    super.onDraw(canvas);
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    Timber.d("onSizeChanged");
    super.onSizeChanged(w, h, oldw, oldh);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    Timber.d("onMeasure");
    //setMeasuredDimension(50, 50);
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    Timber.d("onLayout");
    if (mAdjustViewSize) {
      if (!(getParent() instanceof RelativeLayout)) {
        throw new IllegalStateException("parent is not RelativeLayout!!!");
      }

      RelativeLayout.LayoutParams rl = (RelativeLayout.LayoutParams) getLayoutParams();
      //rl.topMargin = 50;
      //rl.leftMargin = 50;
      int width = ScreenHelper.getScreenHeight(getContext());
      int height = ScreenHelper.getScreenWidth(getContext());
      //rl.width  = (int) (width * 0.5f);
      //rl.height = (int) (height * 0.5f);
      rl.setMargins(0, 0, 0, expandButtonMenu.getBottom());
    }
  }
}
