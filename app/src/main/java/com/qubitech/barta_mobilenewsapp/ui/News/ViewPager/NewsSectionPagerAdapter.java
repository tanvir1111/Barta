package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.qubitech.barta_mobilenewsapp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class NewsSectionPagerAdapter extends FragmentPagerAdapter {

    /**
     * Tabs for tab layout
     */
    private static final int[] TAB_TITLES = new int[]{R.string.bangla, R.string.english, R.string.online};
    private final Context mContext;


    public NewsSectionPagerAdapter(@NonNull FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    /**
     * creates a instance of {@link NewsPaperListFragment} with position
     *
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return NewsPaperListFragment.newInstance(position);
    }

    /**
     * returns title based on the position
     *
     * @param position
     * @return
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    /**
     * @return numberOfTabs
     */
    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
