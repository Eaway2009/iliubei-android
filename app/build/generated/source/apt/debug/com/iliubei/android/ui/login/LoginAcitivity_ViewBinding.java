// Generated code from Butter Knife. Do not modify!
package com.iliubei.android.ui.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iliubei.android.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginAcitivity_ViewBinding<T extends LoginAcitivity> implements Unbinder {
  protected T target;

  @UiThread
  public LoginAcitivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mToolbar = null;

    this.target = null;
  }
}
