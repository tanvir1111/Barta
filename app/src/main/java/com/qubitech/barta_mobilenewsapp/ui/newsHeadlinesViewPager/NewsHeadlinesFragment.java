package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListAdapter;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsHeadlinesFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private NewsHeadlinesViewModel newsHeadlinesViewModel;

    public static NewsHeadlinesFragment newInstance(int index) {
        NewsHeadlinesFragment fragment = new NewsHeadlinesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsHeadlinesViewModel = new ViewModelProvider(this).get(NewsHeadlinesViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        newsHeadlinesViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_headlines, container, false);
        RecyclerView headlinesRecycler = root.findViewById(R.id.news_headlines_recycler);
        headlinesRecycler.setAdapter(new HeadlinesAdapter(getContext(), NewsPaperListAllData.getHeadlines()));
        headlinesRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        newsHeadlinesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}