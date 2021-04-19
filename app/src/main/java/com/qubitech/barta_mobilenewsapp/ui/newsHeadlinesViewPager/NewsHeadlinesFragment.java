package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.API.RestClient;
import com.qubitech.barta_mobilenewsapp.API.RetroInterface;
import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.NewsViewModel;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesAdapter;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData.currentNewspaperIntentARG;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsHeadlinesFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private NewsViewModel newsViewModel;
    private String category;
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
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

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

//        headlinesRecycler.setAdapter(new HeadlinesAdapter(getContext(), NewsPaperListAllData.getHeadlines()));
        headlinesRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       String newsCategory= NewsPaperListAllData.getTabs().get(currentNewspaper)[index];
        Toast.makeText(getContext(), newsCategory, Toast.LENGTH_SHORT).show();

        fetchNews(currentNewspaper,newsCategory);
        newsViewModel.getHeadlinesLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<HeadlinesDataModel>>() {
            @Override
            public void onChanged(ArrayList<HeadlinesDataModel> headlinesDataModels) {
                headlinesRecycler.setAdapter(new HeadlinesAdapter(getContext(),headlinesDataModels));
            }
        });



        return root;
    }

    private void fetchNews(String newspaperName,String newsCategory) {
       RetroInterface retroInterface = RestClient.getRestClient();
        Call<ArrayList<HeadlinesDataModel>> call = retroInterface.getNews(new HeadlinesDataModel(newspaperName,newsCategory));
        call.enqueue(new Callback<ArrayList<HeadlinesDataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<HeadlinesDataModel>> call, Response<ArrayList<HeadlinesDataModel>> response) {
                if (response.isSuccessful()) {
                    newsViewModel.setHeadlinesLiveData(response.body());
//                    Toast.makeText(getContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<HeadlinesDataModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Fatal Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}