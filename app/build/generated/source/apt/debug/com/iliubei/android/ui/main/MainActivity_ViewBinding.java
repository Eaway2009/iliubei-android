// Generated code from Butter Knife. Do not modify!
package com.iliubei.android.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.iliubei.android.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mDrawerMenuRC = Utils.findRequiredViewAsType(source, R.id.drawer_menu_rc, "field 'mDrawerMenuRC'", RecyclerView.class);
    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.drawerLayout, "field 'mDrawerLayout'", DrawerLayout.class);
    target.mtoolBar = Utils.findRequiredViewAsType(source, R.id.toolBar, "field 'mtoolBar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mDrawerMenuRC = null;
    target.mDrawerLayout = null;
    target.mtoolBar = null;

    this.target = null;
  }
}
