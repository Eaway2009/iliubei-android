// Generated code from Butter Knife. Do not modify!
package com.iliubei.android.ui.editor;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iliubei.android.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditorDetailActivity_ViewBinding<T extends EditorDetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public EditorDetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.mWebView = Utils.findRequiredViewAsType(source, R.id.webview, "field 'mWebView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mToolbar = null;
    target.mWebView = null;

    this.target = null;
  }
}
