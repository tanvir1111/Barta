package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListAdapter;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;

import java.util.ArrayList;
import java.util.List;


public class NewsPaperListFragment extends Fragment {



    int sectionNum = 0;
    List<NewsPaperListDataModel> newsPaperListData;
    NewspaperViewModel newspaperViewModel;



    public static NewsPaperListFragment newInstance(int index) {

        Bundle args = new Bundle();
        args.putInt("SECTION",index);

        NewsPaperListFragment fragment = new NewsPaperListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsPaperListData = new ArrayList<>();
        newspaperViewModel = new ViewModelProvider(this).get(NewspaperViewModel.class);


        if(getArguments()!=null){
            sectionNum = getArguments().getInt("SECTION");

        }


    }



    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_paper_list, container, false);
        RecyclerView newsPapersRecycler = root.findViewById(R.id.newspaper_list_recycler);
        newsPapersRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        switch (sectionNum){


            case 1:
                if(newspaperViewModel.getFavorites(1).getValue()==null){
                    keepFavoritesFirst(NewsPapersStaticData.getEnglishNewsPapers());
                    newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                }
                newspaperViewModel.getFavorites(1).observe(getViewLifecycleOwner(), new Observer<List<NewsPaperListDataModel>>() {
                    @Override
                    public void onChanged(List<NewsPaperListDataModel> newsPaperListDataModels) {
                        newsPaperListData.clear();
                        newsPaperListData = newsPaperListDataModels;
                        keepFavoritesFirst(NewsPapersStaticData.getEnglishNewsPapers());
                        newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                    }
                });

                break;
            case 2:
                if(newspaperViewModel.getFavorites(2).getValue()==null){
                    keepFavoritesFirst(NewsPapersStaticData.getOnlineNewsPapers());
                    newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                }
                newspaperViewModel.getFavorites(2).observe(getViewLifecycleOwner(), new Observer<List<NewsPaperListDataModel>>() {
                    @Override
                    public void onChanged(List<NewsPaperListDataModel> newsPaperListDataModels) {
                        newsPaperListData.clear();
                        newsPaperListData = newsPaperListDataModels;
                        keepFavoritesFirst(NewsPapersStaticData.getOnlineNewsPapers());
                        newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                    }
                });
                break;
            default:
                if(newspaperViewModel.getFavorites(0).getValue()==null){
                    keepFavoritesFirst(NewsPapersStaticData.getBengaliNewsPapers());
                    newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                }
                newspaperViewModel.getFavorites(0).observe(getViewLifecycleOwner(), new Observer<List<NewsPaperListDataModel>>() {
                    @Override
                    public void onChanged(List<NewsPaperListDataModel> newsPaperListDataModels) {
                        newsPaperListData.clear();
                       newsPaperListData = newsPaperListDataModels;
//                        Toast.makeText(getContext(), newsPaperListDataModels.get(0).getNameID(), Toast.LENGTH_SHORT).show();
                        keepFavoritesFirst(NewsPapersStaticData.getBengaliNewsPapers());
                        newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData,newspaperViewModel));
                    }
                });
                break;

        }

        return root;
    }

    private void keepFavoritesFirst(ArrayList<NewsPaperListDataModel> newsPaperListStaticData) {

        for (NewsPaperListDataModel  newsPaper:
             newsPaperListStaticData) {
            int n=0;
         for(int i=0;i<newsPaperListData.size();i++){
             if(newsPaperListData.get(i).getNameID()==newsPaper.getNameID()){
                 n=1;
             }
         }
         if(n==0){
             newsPaperListData.add(newsPaper);
         }

        }

    }
}