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


public class NewsPaperListFragment extends Fragment {




    ArrayList<NewsPaperListDataModel> newsPaperListData;

    public NewsPaperListFragment(ArrayList<NewsPaperListDataModel> newsPaperListData) {
        this.newsPaperListData = newsPaperListData;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_paper_list, container, false);
        RecyclerView newsPapersRecycler = root.findViewById(R.id.newspaper_list_recycler);

        newsPapersRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

       newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData));
        return root;
    }
}