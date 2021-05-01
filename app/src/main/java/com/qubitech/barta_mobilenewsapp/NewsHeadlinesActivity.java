package com.qubitech.barta_mobilenewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPapersStaticData;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.NewsHeadlinesSectionsPagerAdapter;

import java.util.HashMap;

import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPapersStaticData.currentNewspaperIntentARG;

public class NewsHeadlinesActivity extends AppCompatActivity {
    private static HashMap<String, String[]> tabs =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_headlines);
        String newsPaperName = getIntent().getStringExtra(currentNewspaperIntentARG);

        TextView title = findViewById(R.id.appbar_title);
        title.setText(newsPaperName);
        ImageView backBtn = findViewById(R.id.appbar_back_btn);


        NewsHeadlinesSectionsPagerAdapter newsHeadlinesSectionsPagerAdapter = new NewsHeadlinesSectionsPagerAdapter(this, getSupportFragmentManager(), NewsPapersStaticData.getTabs().get(newsPaperName));
        ViewPager viewPager = findViewById(R.id.news_headlines_view_pager);
        viewPager.setAdapter(newsHeadlinesSectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.news_headlines_tab_layout);
        tabs.setupWithViewPager(viewPager);


        Toast.makeText(this,newsPaperName , Toast.LENGTH_SHORT).show();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsHeadlinesActivity.super.onBackPressed();
            }
        });

    }
}