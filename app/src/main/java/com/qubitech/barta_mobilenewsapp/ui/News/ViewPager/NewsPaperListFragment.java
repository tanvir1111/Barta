package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListAdapter;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListDataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsPaperListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsPaperListFragment extends Fragment {
   private static final String ARG_SECTION_NUMBER = "section_number";
   private ArrayList<NewsPaperListDataModel> bengaliNewspapers,englishNewspapers,onlineNewspapers;

    private NewsPaperListViewModel newsPaperListViewModel;

    public static NewsPaperListFragment newInstance(int index) {
        NewsPaperListFragment fragment = new NewsPaperListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bengaliNewspapers = new ArrayList<>();
        englishNewspapers = new ArrayList<>();
        onlineNewspapers = new ArrayList<>();

        bengaliNewspapers.add(new NewsPaperListDataModel("দৈনিক প্রথম আলো",R.drawable.prothomalo));
        bengaliNewspapers.add(new NewsPaperListDataModel("দৈনিক ইত্তেফাক",R.drawable.ittefaq));
        bengaliNewspapers.add(new NewsPaperListDataModel("দৈনিক যুগান্তর",R.drawable.jugantor));
        bengaliNewspapers.add(new NewsPaperListDataModel("দৈনিক কালেরকন্ঠ",R.drawable.kalerkontho));

        newsPaperListViewModel = new ViewModelProvider(this).get(NewsPaperListViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        switch (index){
            case 0:
                newsPaperListViewModel.setData(bengaliNewspapers);
                break;
            case 1:
                newsPaperListViewModel.setData(englishNewspapers);
                break;
            case 2:
                newsPaperListViewModel.setData(onlineNewspapers);
                break;
        }

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_paper_list, container, false);
        RecyclerView newsPapersRecycler = root.findViewById(R.id.newspaper_list_recycler);

        newsPapersRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        newsPaperListViewModel.getNewsPapers().observe(getViewLifecycleOwner(), new Observer<ArrayList<NewsPaperListDataModel>>() {
            @Override
            public void onChanged(ArrayList<NewsPaperListDataModel> newsPaperListDataModels) {
                newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListDataModels));
            }
        });
        return root;
    }
}