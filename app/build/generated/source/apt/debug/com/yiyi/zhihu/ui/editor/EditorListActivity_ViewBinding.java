// Generated code from Butter Knife. Do not modify!
package com.yiyi.zhihu.ui.editor;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yiyi.zhihu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditorListActivity_ViewBinding<T extends EditorListActivity> implements Unbinder {
  protected T target;

  @UiThread
  public EditorListActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mToolbar'", Toolbar.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mToolbar = null;
    target.mRecyclerView = null;

    this.target = null;
  }
}
