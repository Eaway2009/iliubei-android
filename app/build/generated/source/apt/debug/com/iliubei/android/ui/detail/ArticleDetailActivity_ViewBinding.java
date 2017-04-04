// Generated code from Butter Knife. Do not modify!
package com.iliubei.android.ui.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iliubei.android.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleDetailActivity_ViewBinding<T extends ArticleDetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ArticleDetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.detailBarTitle = Utils.findRequiredViewAsType(source, R.id.detail_bar_title, "field 'detailBarTitle'", TextView.class);
    target.detailBarCopyright = Utils.findRequiredViewAsType(source, R.id.detail_bar_copyright, "field 'detailBarCopyright'", TextView.class);
    target.detailContentWV = Utils.findRequiredViewAsType(source, R.id.wv_detail_content, "field 'detailContentWV'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mToolbar = null;
    target.detailBarTitle = null;
    target.detailBarCopyright = null;
    target.detailContentWV = null;

    this.target = null;
  }
}
