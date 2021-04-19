package com.qubitech.barta_mobilenewsapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;
import com.squareup.picasso.Picasso;

import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData.detailedNewsIntentARG;

public class DetailedNewsActivity extends AppCompatActivity {
    private TextView title,section,headline,details,date_time;
    private ImageView backBtn,newsImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);
//        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//        getSupportActionBar().setCustomView(R.layout.appbar_with_back);
//        getSupportActionBar().setElevation(10);
//        View view = getSupportActionBar().getCustomView();


        title = findViewById(R.id.appbar_title);
        section = findViewById(R.id.section_name);
        backBtn = findViewById(R.id.appbar_back_btn);
        newsImage = findViewById(R.id.news_image);
        headline = findViewById(R.id.news_headline);
        details = findViewById(R.id.detailed_news);
        date_time = findViewById(R.id.date_and_time);

        HeadlinesDataModel detailedNews = (HeadlinesDataModel) getIntent().getSerializableExtra(detailedNewsIntentARG);
        details.setText(detailedNews.getDescription());
        date_time.setText(detailedNews.getDate_time());
        headline.setText(detailedNews.getHeadline());


//        Toast.makeText(this, detailedNews.getHeadline(), Toast.LENGTH_SHORT).show();
        title.setText(detailedNews.getNewspaperName());
        section.setText(detailedNews.getNewsCategory());
        Picasso.get().load(detailedNews.getUrl()).into(newsImage);
//      Toast.makeText(this, NewsPaperListAllData.currentNewspaperSection, Toast.LENGTH_SHORT).show();



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailedNewsActivity.super.onBackPressed();
            }
        });
    }
}