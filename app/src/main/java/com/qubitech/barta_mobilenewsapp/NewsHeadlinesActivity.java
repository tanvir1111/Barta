package com.qubitech.barta_mobilenewsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.NewsHeadlinesSectionsPagerAdapter;

import java.util.HashMap;

import static com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData.currentNewspaperIntentARG;

public class NewsHeadlinesActivity extends AppCompatActivity {
    private static HashMap<String, String[]> tabs =new HashMap<>();
    private TabLayout tabLayout;
    private NewsHeadlinesSectionsPagerAdapter newsHeadlinesSectionsPagerAdapter;
    private ViewPager viewPager;
    private TextView title;
    private ImageView backBtn;
    private String newsPaperName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_headlines);
        String newsPaperName = getIntent().getStringExtra(currentNewspaperIntentARG);

         title = findViewById(R.id.appbar_title);
        title.setText(newsPaperName);
         backBtn = findViewById(R.id.appbar_back_btn);


         newsHeadlinesSectionsPagerAdapter = new NewsHeadlinesSectionsPagerAdapter(this, getSupportFragmentManager(), NewsPapersStaticData.getTabs().get(newsPaperName));
         viewPager = findViewById(R.id.news_headlines_view_pager);
         viewPager.setAdapter(newsHeadlinesSectionsPagerAdapter);
         tabLayout = findViewById(R.id.news_headlines_tab_layout);
         tabLayout.setupWithViewPager(viewPager);


        Toast.makeText(this,newsPaperName , Toast.LENGTH_SHORT).show();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsHeadlinesActivity.super.onBackPressed();
            }
        });

    }
}