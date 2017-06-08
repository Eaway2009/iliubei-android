package com.iliubei.android.ui.main;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.iliubei.android.R;
import com.iliubei.android.entity.commonEntity.CategoryEntity;
import com.iliubei.android.entity.themeDaily.ThemesEntity;
import com.iliubei.android.global.Constants;
import com.iliubei.android.mvpframe.base.BaseFrameActivity;
import com.iliubei.android.ui.drawer.DisplaybleItem;
import com.iliubei.android.ui.drawer.DrawerHeaderItem;
import com.iliubei.android.ui.drawer.DrawerHomeItem;
import com.iliubei.android.ui.drawer.HYDrawerMenuAdapter;
import com.iliubei.android.ui.home.HomeFragment;
import com.iliubei.android.ui.list.ListFragment;
import com.iliubei.android.ui.login.LoginAcitivity;
import com.iliubei.android.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaway on 2017/4/4.
 */
public class MainActivity extends BaseFrameActivity<DrawerMainPresenter, DrawerMainModel>
        implements HYDrawerMenuAdapter.onItemClickListener,
        Toolbar.OnMenuItemClickListener, DrawerMainContract.View {

    @BindView(R.id.drawer_menu_rc)
    RecyclerView mDrawerMenuRC;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolBar)
    Toolbar mtoolBar;

    private static final String TAG = "MainActivity";

    private List<DisplaybleItem> mMainMenuList;

    private HYDrawerMenuAdapter mMenuAdapter;

    private Context mContext;

    private HomeFragment mCommonFragment;
    private ListFragment mListFragment;

    private static final int FRAGMENT_HOME = 1;
    private static final int FRAGMENT_LIST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        setExit(true);
    }

    @Override
    public void initData() {
        super.initData();

        mMainMenuList = new ArrayList<>();
        mMainMenuList.add(new DrawerHeaderItem());
        mMainMenuList.add(new DrawerHomeItem());
        mPresenter.getOtherThemes();
        mMenuAdapter = new HYDrawerMenuAdapter(mContext, mMainMenuList);

        mCommonFragment = new HomeFragment();
        mListFragment = new ListFragment();
    }

    @Override
    public void initView() {
        initToolBar();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mDrawerMenuRC.setLayoutManager(layoutManager);
        mDrawerMenuRC.setAdapter(mMenuAdapter);

        setFragmentId(R.id.container);
        setCurrFragment(mCommonFragment);
        toFragment(R.id.container, mCommonFragment);
    }

    private void initToolBar() {
        mtoolBar.inflateMenu(R.menu.menu_main);
        mtoolBar.setTitle(mContext.getResources().getString(R.string.topic_list_home));
        mtoolBar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_actionbar_menu));
        mtoolBar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ic_actionbar_menu_overflow));
    }

    @Override
    public void initListener() {
        mtoolBar.setOnMenuItemClickListener(this);
        mtoolBar.setNavigationOnClickListener(this);
        mMenuAdapter.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            default:
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    mDrawerLayout.closeDrawers();
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
    }

    @Override
    public void onDrawerHeaderItemClick() {
        openActivity(LoginAcitivity.class);
    }

    @Override
    public void onItemViewClick(View view, RecyclerView.ViewHolder holder, int position) {

        // switch articles
        if (position == 1) {
            switchFragment(Constants.StoryType.STORY_HOME, getResources().getString(R.string.topic_list_home), -1);
        } else {
            CategoryEntity themeEntity = (CategoryEntity) mMainMenuList.get(position);
            if (themeEntity.getTypeid() != null) {
                int typeId = 0;
                try {
                    typeId = Integer.valueOf(themeEntity.getTypeid());
                } catch (Exception e) {
                    Log.e(TAG, "getTypeid", e);
                }
                switchFragment(Constants.StoryType.STORY_THEME, themeEntity.getName(), typeId);
            }
        }


        mDrawerLayout.closeDrawers();
    }

    private void switchFragment(String type, String title, int id) {

        if (type.equals(Constants.StoryType.STORY_HOME)) {
            mCommonFragment.TYPE = type;
            mCommonFragment.themeId = id;
            mtoolBar.getMenu().findItem(R.id.action_follow).setVisible(false);
            mtoolBar.getMenu().findItem(R.id.action_notice).setVisible(true);
            mtoolBar.getMenu().findItem(R.id.action_switch_model).setVisible(true);
            mtoolBar.getMenu().findItem(R.id.action_config).setVisible(true);
            mtoolBar.hideOverflowMenu();
            mtoolBar.setTitle(title);

            toFragment(R.id.container, mCommonFragment);
            if (mCommonFragment.isAdded()) {
                mCommonFragment.getData();
            }
        } else {
            mListFragment.themeId = id;
            mtoolBar.getMenu().findItem(R.id.action_follow).setVisible(true);
            mtoolBar.getMenu().findItem(R.id.action_notice).setVisible(false);
            mtoolBar.getMenu().findItem(R.id.action_switch_model).setVisible(false);
            mtoolBar.getMenu().findItem(R.id.action_config).setVisible(false);
            mtoolBar.showOverflowMenu();
            mtoolBar.setTitle(title);

            toFragment(R.id.container, mListFragment);
            if (mListFragment.isAdded()) {
                mListFragment.getData();
            }
        }
    }

    @Override
    public void onFollowIVClick(View view, RecyclerView.ViewHolder holder, int position, int offset) {
        ToastUtils.showToast(this, "关注成功 内容将会在主页显示");
    }

    /**
     * ToolBar menu item_story_list_section_head click callback
     *
     * @param item menu item_story_list_section_head
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_notice:
                // TODO: 2016/12/28 是否登录判断
                if (false) {
                    // TODO: 2016/12/28 跳转账号消息界面
                } else {
                    openActivity(LoginAcitivity.class);
                }
                break;

            case R.id.action_switch_model:
                String curTheme = mThemeUtil.getTheme();
                MenuItem switchModel = mtoolBar.getMenu().findItem(R.id.action_switch_model);
                switch (curTheme) {
                    case Constants.Theme.DAY_THEME:
                        switchModel.setTitle(this.getResources().getString(R.string.action_switch_day));
                        setTheme(R.style.NightTheme);
                        mThemeUtil.setTheme(Constants.Theme.NIGHT_THEME);
                        changeTheme();
                        break;
                    case Constants.Theme.NIGHT_THEME:
                        switchModel.setTitle(this.getResources().getString(R.string.action_switch_night));
                        setTheme(R.style.DayTheme);
                        mThemeUtil.setTheme(Constants.Theme.DAY_THEME);
                        changeTheme();
                        break;
                }
                break;

            case R.id.action_config:
                // TODO: 2016/12/28 跳转配置界面

                break;

        }
        return true;
    }

    private void changeTheme() {
        refreshUI();
    }

    private void refreshUI() {
        TypedValue toolbarColor = new TypedValue();

        Resources.Theme theme = getTheme();
        theme.resolveAttribute(R.attr.toolbarColor, toolbarColor, true);

        mtoolBar.setBackgroundColor(ContextCompat.getColor(this, toolbarColor.resourceId));
    }

    @Override
    public void loadOtherThemeList(ThemesEntity themesEntity) {
        mMainMenuList.clear();
        mMainMenuList.add(new DrawerHeaderItem());
        mMainMenuList.add(new DrawerHomeItem());
        mMainMenuList.addAll(themesEntity.getCategorys());
        mMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestError(String msg) {
        ToastUtils.showToast(this, msg);
    }

    @Override
    public void onRequestEnd() {

    }

}

