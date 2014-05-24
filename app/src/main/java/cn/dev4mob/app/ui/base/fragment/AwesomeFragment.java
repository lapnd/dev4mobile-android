package cn.dev4mob.app.ui.base.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import timber.log.Timber;

/**
 * Created by dev4mobile on 5/24/14.
 */
public class AwesomeFragment extends Fragment {

  public static final boolean debug = true;

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (debug) {
      Timber.d("onAttach");
    }
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (debug) {
      Timber.d("onCreate");
    }
    if (getActivity().getActionBar() != null) {
      getActivity().getActionBar().hide();
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    if (debug) {
      Timber.d("onCreateView");
    }
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (debug) {
      Timber.d("onActivityCreated");
    }
  }

  @Override public void onResume() {
    super.onResume();
    if (debug) {
      Timber.d("onResume");
    }
  }

  @Override public void onStart() {
    super.onStart();
    if (debug) {
      Timber.d("onStart");
    }
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (debug) {
      Timber.d("onDestroyView");
    }
  }

  @Override public void onPause() {
    super.onPause();
    if (debug) {
      Timber.d("onPause");
    }
  }

  @Override public void onStop() {
    super.onStop();
    if (debug) {
      Timber.d("onStop");
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    if (debug) {
      Timber.d("onDestroy");
    }
  }
}
