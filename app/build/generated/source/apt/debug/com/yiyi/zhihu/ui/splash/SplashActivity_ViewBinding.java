// Generated code from Butter Knife. Do not modify!
package com.yiyi.zhihu.ui.splash;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yiyi.zhihu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashActivity_ViewBinding<T extends SplashActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SplashActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mSplashImgView = Utils.findRequiredViewAsType(source, R.id.splash_image, "field 'mSplashImgView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mSplashImgView = null;

    this.target = null;
  }
}
