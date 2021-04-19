package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager;

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

    private String[] tabTitles;
    private final Context mContext;

    public NewsHeadlinesSectionsPagerAdapter(Context context, FragmentManager fm, String[] tabTitles) {
        super(fm);
        mContext = context;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
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