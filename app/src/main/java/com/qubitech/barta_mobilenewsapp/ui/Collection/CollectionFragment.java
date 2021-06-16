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

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesAdapter;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.util.List;


public class CollectionFragment extends Fragment {

    private CollectionViewModel collectionViewModel;
    private RecyclerView collectionRecycler;
    private TextView noCollectionText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        collectionViewModel = new ViewModelProvider(this).get(CollectionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_collection, container, false);

        collectionRecycler = root.findViewById(R.id.collection_recycler);
        noCollectionText = root.findViewById(R.id.no_collection);

        collectionRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        collectionViewModel.getHeadlines().observe(getViewLifecycleOwner(), new Observer<List<HeadlinesDataModel>>() {
            @Override
            public void onChanged(List<HeadlinesDataModel> headlinesDataModels) {
                if (headlinesDataModels.size() == 0) {
                    noCollectionText.setVisibility(View.VISIBLE);
                } else {
                    noCollectionText.setVisibility(View.GONE);
                }
                collectionRecycler.setAdapter(new HeadlinesAdapter(getContext(), headlinesDataModels));

            }
        });


        return root;
    }

}