package com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class NewsHeadlinesSectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private String[] tabTitles;

    /**
     * @param context
     * @param fm
     * @param tabTitles tab titles from {@link com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData}
     */
    public NewsHeadlinesSectionsPagerAdapter(Context context, FragmentManager fm, String[] tabTitles) {
        super(fm);
        mContext = context;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {

        return NewsHeadlinesFragment.newInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return tabTitles.length;
    }
}