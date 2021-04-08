package com.qubitech.barta_mobilenewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.NewsHeadlinesSectionsPagerAdapter;

import java.util.HashMap;

public class NewsHeadlinesActivity extends AppCompatActivity {
    private static HashMap<String, String[]> tabs =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_headlines);
        String newsPaperName = getIntent().getStringExtra("NewspaperName");

        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.appbar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView title = view.findViewById(R.id.appbar_title);
        title.setText(newsPaperName);


        NewsHeadlinesSectionsPagerAdapter newsHeadlinesSectionsPagerAdapter = new NewsHeadlinesSectionsPagerAdapter(this, getSupportFragmentManager(), NewsPaperListAllData.getTabs().get(newsPaperName));
        ViewPager viewPager = findViewById(R.id.news_headlines_view_pager);
        viewPager.setAdapter(newsHeadlinesSectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.news_headlines_tab_layout);
        tabs.setupWithViewPager(viewPager);


        Toast.makeText(this,newsPaperName , Toast.LENGTH_SHORT).show();



    }
}