package com.qubitech.barta_mobilenewsapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.qubitech.barta_mobilenewsapp.ui.Collection.CollectionViewModel;

import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import static com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData.detailedNewsIntentARG;

public class DetailedNewsActivity extends AppCompatActivity {
    private TextView title,section,headline,details,date_time;
    private ImageView backBtn,newsImage,collectionBtn,shareBtn;
    private CollectionViewModel collectionViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);

        collectionViewModel= new ViewModelProvider(this).get(CollectionViewModel.class);
        HeadlinesDataModel detailedNews = (HeadlinesDataModel) getIntent().getSerializableExtra(detailedNewsIntentARG);

        title = findViewById(R.id.appbar_title);
        section = findViewById(R.id.section_name);
        backBtn = findViewById(R.id.appbar_back_btn);
        newsImage = findViewById(R.id.news_image);
        headline = findViewById(R.id.news_headline);
        details = findViewById(R.id.detailed_news);
        date_time = findViewById(R.id.date_and_time);
        collectionBtn = findViewById(R.id.collection_btn);
        shareBtn = findViewById(R.id.share_btn);

        if(collectionViewModel.getNews(detailedNews.getNewsUrl())!= null){
            collectionBtn.setImageResource(R.drawable.collection);
            collectionBtn.setColorFilter(getColor(R.color.red_primary));
        }

        if(detailedNews.getDescription().contains("</")){
            details.setText(Html.fromHtml( detailedNews.getDescription()));
        }
        else {
            if(detailedNews.getDescription()==null){
                details.setText("");

            }
            details.setText(detailedNews.getDescription());
        }

        date_time.setText(detailedNews.getDate_time());
        headline.setText(detailedNews.getHeadline());
        title.setText(detailedNews.getNewspaperName());
        section.setText(detailedNews.getNewsCategory());
        if(detailedNews.getImageUrl().isEmpty()){
            newsImage.setImageResource(R.drawable.image_failed);
        }
        else {
            Picasso.get().load(detailedNews.getImageUrl()).into(newsImage, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    newsImage.setImageResource(R.drawable.image_failed);

                }
            });


        }

        collectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(collectionViewModel.getNews(detailedNews.getNewsUrl()) ==null){
                    collectionViewModel.insert(detailedNews);
                    collectionBtn.setImageResource(R.drawable.collection);
                    collectionBtn.setColorFilter(getColor(R.color.red_primary));

                }
                else {
                    collectionViewModel.delete(detailedNews);
                    collectionBtn.setImageResource(R.drawable.collection_red);


                }

            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,detailedNews.getNewsUrl());
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"How do you want to share?"));
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