package cn.dev4mob.app.utils;

import android.animation.Animator;

public class AnimationUtils {
    public static Animator.AnimatorListener withEndAction(final Runnable runnable) {
        return new Animator.AnimatorListener() {
            public void onAnimationStart(Animator animation) {
            }
 
            public void onAnimationEnd(Animator animation) {
                runnable.run();
            }
 
            public void onAnimationCancel(Animator animation) {
            }
 
            public void onAnimationRepeat(Animator animation) {
            }
        };
    }
}