package com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPapersStaticData;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesAdapter;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.List;

import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPapersStaticData.currentNewspaperIntentARG;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsHeadlinesFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private NewsHeadlinesViewModel newsHeadlinesViewModel;

    int index=0;

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


        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);

        }

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_headlines, container, false);
        RecyclerView headlinesRecycler = root.findViewById(R.id.news_headlines_recycler);
        String currentNewspaper = getActivity().getIntent().getStringExtra(currentNewspaperIntentARG);
        String newsCategory= NewsPapersStaticData.getTabs().get(currentNewspaper)[index];

        headlinesRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        newsHeadlinesViewModel.getNews(currentNewspaper,newsCategory).observe(getViewLifecycleOwner(), new Observer<List<HeadlinesDataModel>>() {
            @Override
            public void onChanged(List<HeadlinesDataModel> headlinesDataModels) {
                headlinesRecycler.setAdapter(new HeadlinesAdapter(getContext(),headlinesDataModels));

            }
        });


        return root;
    }


}