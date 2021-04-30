package com.qubitech.barta_mobilenewsapp.ui.Collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.qubitech.barta_mobilenewsapp.API.RoomDB;
import com.qubitech.barta_mobilenewsapp.R;

import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesAdapter;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;



public class CollectionFragment extends Fragment {

    private CollectionViewModel collectionViewModel;
    RecyclerView collectionRecycler;
    TextView noCollectionText;
    RoomDB database;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        collectionViewModel = CollectionViewModel.getInstance(this);
        View root = inflater.inflate(R.layout.fragment_collection, container, false);

        collectionRecycler = root.findViewById(R.id.collection_recycler);
        noCollectionText=root.findViewById(R.id.no_collection);
        database= RoomDB.getInstance(getContext());


//        headlinesRecycler.setAdapter(new HeadlinesAdapter(getContext(), NewsPaperListAllData.getHeadlines()));
        collectionRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        updateCollectionsViewModel();


        collectionViewModel.getCollectionsLiveData().observe(getViewLifecycleOwner(), new Observer<ArrayList<HeadlinesDataModel>>() {
            @Override
            public void onChanged(ArrayList<HeadlinesDataModel> headlinesDataModels) {
                if(headlinesDataModels.size()==0){
                    noCollectionText.setVisibility(View.VISIBLE);
                }
                else {
                    noCollectionText.setVisibility(View.GONE);
                }
                collectionRecycler.setAdapter(new HeadlinesAdapter(getContext(), headlinesDataModels));
            }
        });


        return root;
    }
    public void updateCollectionsViewModel(){
        collectionViewModel.setCollectionsLiveData((ArrayList<HeadlinesDataModel>) database.collectionDao().getAll());
    }
}