package com.qubitech.barta_mobilenewsapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.qubitech.barta_mobilenewsapp.API.RoomDB;

import com.qubitech.barta_mobilenewsapp.ui.Collection.CollectionViewModel;

import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData.detailedNewsIntentARG;

public class DetailedNewsActivity extends AppCompatActivity {
    private TextView title,section,headline,details,date_time;
    private ImageView backBtn,newsImage,collectionBtn;
    RoomDB database;
    CollectionViewModel collectionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);
//        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//        getSupportActionBar().setCustomView(R.layout.appbar_with_back);
//        getSupportActionBar().setElevation(10);
//        View view = getSupportActionBar().getCustomView();
        collectionViewModel= CollectionViewModel.getInstance(this);
        database= RoomDB.getInstance(this);
        HeadlinesDataModel detailedNews = (HeadlinesDataModel) getIntent().getSerializableExtra(detailedNewsIntentARG);
//        if(collectionViewModel==null){
//            collectionViewModel = new ViewModelProvider(this).get(CollectionViewModel.class);
//        }



        title = findViewById(R.id.appbar_title);
        section = findViewById(R.id.section_name);
        backBtn = findViewById(R.id.appbar_back_btn);
        newsImage = findViewById(R.id.news_image);
        headline = findViewById(R.id.news_headline);
        details = findViewById(R.id.detailed_news);
        date_time = findViewById(R.id.date_and_time);
        collectionBtn = findViewById(R.id.collection_btn);

        if(database.collectionDao().getNews(detailedNews.getHeadline())!= null){
            collectionBtn.setImageResource(R.drawable.collection);
            collectionBtn.setColorFilter(getColor(R.color.red_primary));

        }

        details.setText(detailedNews.getDescription());
        date_time.setText(detailedNews.getDate_time());
        headline.setText(detailedNews.getHeadline());




//        Toast.makeText(this, detailedNews.getHeadline(), Toast.LENGTH_SHORT).show();
        title.setText(detailedNews.getNewspaperName());
        section.setText(detailedNews.getNewsCategory());
        Picasso.get().load(detailedNews.getUrl()).into(newsImage);
//      Toast.makeText(this, NewsPaperListAllData.currentNewspaperSection, Toast.LENGTH_SHORT).show();
        collectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(database.collectionDao().getNews(detailedNews.getHeadline()) ==null){
                    database.collectionDao().insert(detailedNews);
                    collectionBtn.setImageResource(R.drawable.collection);
                    collectionBtn.setColorFilter(getColor(R.color.red_primary));

                }
                else {
                    database.collectionDao().delete(detailedNews);
                    collectionBtn.setImageResource(R.drawable.collection_red);


                }
                collectionViewModel.setCollectionsLiveData((ArrayList<HeadlinesDataModel>) database.collectionDao().getAll());




            }
        });



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailedNewsActivity.super.onBackPressed();
            }
        });
    }
}