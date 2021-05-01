package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListAdapter;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;

import java.util.ArrayList;


public class NewsPaperListFragment extends Fragment {



    int sectionNum = 0;
    ArrayList<NewsPaperListDataModel> newsPaperListData;



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


        if(getArguments()!=null){
            sectionNum = getArguments().getInt("SECTION");

        }
        switch (sectionNum){


            case 1:
                newsPaperListData =  NewsPapersStaticData.getEnglishNewsPapers();
                break;
            case 2:
                newsPaperListData =  NewsPapersStaticData.getOnlineNewsPapers();
                break;
            default:
                newsPaperListData =  NewsPapersStaticData.getBengaliNewsPapers();
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

        newsPapersRecycler.setAdapter(new NewsPaperListAdapter(getContext(),newsPaperListData));
        return root;
    }


}