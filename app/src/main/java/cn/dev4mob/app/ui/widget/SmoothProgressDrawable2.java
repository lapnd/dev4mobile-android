package cn.dev4mob.app.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by dev4mobile on 5/31/14.
 */
public class SmoothProgressDrawable2 extends Drawable implements Animatable {

  private boolean mRunning;
  private float mCurrentOffset;
  private static final float OFFSET_PER_FRAME = 0.01f;
  private boolean mNewTurn;
  private static final long FRAME_DURATION = 1000 / 60;
  private Interpolator mInterpolator;
  private int mSectionsCount;
  private int[] mColors;
  private float mSpeed;
  private boolean mReversed;
  private boolean mMirrorMode;
  private int mStrokeSeparatorLength;
  private int mStrokeWidth;

  public SmoothProgressDrawable2(Interpolator interpolator, int sectionsCount, int[] colors,
      float speed, boolean reversed, boolean mirrorMode, int strokeSeparatorLength,
      int strokeWidth) {
    this.mInterpolator = interpolator;
    this.mSectionsCount = sectionsCount;
    this.mColors = colors;
    this.mSpeed = speed;
    this.mReversed = reversed;
    this.mMirrorMode = mirrorMode;
    this.mStrokeSeparatorLength = strokeSeparatorLength;
    this.mStrokeWidth = strokeWidth;
  }

  @Override public void start() {
  }

  @Override public void stop() {
  }

  @Override public boolean isRunning() {
    return mRunning;
  }

  @Override public void draw(Canvas canvas) {

  }

  @Override public void setAlpha(int alpha) {

  }

  @Override public void setColorFilter(ColorFilter cf) {

  }

  @Override public int getOpacity() {
    return 0;
  }

  @Override public void scheduleSelf(Runnable what, long when) {
    mRunning = true;
    super.scheduleSelf(what, when);
  }

  private final Runnable mUpdater = new Runnable() {

    @Override public void run() {
      mCurrentOffset += (OFFSET_PER_FRAME * mSpeed);
      if (mCurrentOffset >= (1f / mSectionsCount)) {
        mNewTurn = true;
        mCurrentOffset = 0f;
      }
      scheduleSelf(mUpdater, SystemClock.uptimeMillis() + FRAME_DURATION);
      invalidateSelf();
    }
  };

  public static class Builder {

    private Interpolator mInterpolator;
    private int mSectionsCount;
    private int[] mColors;
    private float mSpeed;
    private boolean mReversed;
    private boolean mMirrorMode;
    private int mStrokeSeparatorLength;
    private int mStrokeWidth;

    public Builder(Context context) {
      initDefautVaule(context);
    }

    private void initDefautVaule(Context context) {
      mInterpolator = new LinearInterpolator();
      mColors = new int[] { context.getResources().getColor(android.R.color.holo_blue_bright) };
    }

    public SmoothProgressDrawable2 build() {
      return new SmoothProgressDrawable2(mInterpolator, mSectionsCount, mColors, mSpeed, mReversed,
          mMirrorMode, mStrokeSeparatorLength, mStrokeWidth);
    }

    public Builder withInterpolator(Interpolator interpolator) {
      if (interpolator == null) {
        throw new IllegalArgumentException("interpolator can't be null");
      }
      this.mInterpolator = interpolator;
      return this;
    }

    public Builder withColor(int color) {
      int[] colors = new int[] { color };
      this.mColors = colors;
      return this;
    }

    public Builder withColors(int[] colors) {
      if (colors == null || colors.length == 0) {
        throw new IllegalArgumentException("colors must not be empty");
      }
      this.mColors = colors;
      return this;
    }

    public Builder withSpeed(float speed) {
      if (speed < 0) throw new IllegalArgumentException("speed must be >= 0");
      this.mSpeed = speed;
      return this;
    }

    public Builder withSectionCount(int sectionCount) {
      this.mSectionsCount = sectionCount;
      return this;
    }
  }
}
