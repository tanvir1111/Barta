package com.qubitech.barta_mobilenewsapp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.NewsHeadlinesSectionsPagerAdapter;

import java.util.HashMap;

import static com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData.currentNewspaperIntentARG;

public class NewsHeadlinesActivity extends AppCompatActivity {
    private static HashMap<String, String[]> tabs =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_headlines);
        String newsPaperName = getIntent().getStringExtra(currentNewspaperIntentARG);

//        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//        getSupportActionBar().setCustomView(R.layout.appbar_with_back);
//        //getSupportActionBar().setElevation(0);
//        View view = getSupportActionBar().getCustomView();
        TextView title = findViewById(R.id.appbar_title);
        title.setText(newsPaperName);
        ImageView backBtn = findViewById(R.id.appbar_back_btn);


        NewsHeadlinesSectionsPagerAdapter newsHeadlinesSectionsPagerAdapter = new NewsHeadlinesSectionsPagerAdapter(this, getSupportFragmentManager(), NewsPaperListAllData.getTabs().get(newsPaperName));
        ViewPager viewPager = findViewById(R.id.news_headlines_view_pager);
        viewPager.setAdapter(newsHeadlinesSectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.news_headlines_tab_layout);
        tabs.setupWithViewPager(viewPager);
//        NewsPaperListAllData.currentNewspaperSection = newsHeadlinesSectionsPagerAdapter.getPageTitle(viewPager.getCurrentItem()).toString();

//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Toast.makeText(NewsHeadlinesActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
//                NewsPaperListAllData.currentNewspaperSection = newsHeadlinesSectionsPagerAdapter.getPageTitle(position).toString();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        Toast.makeText(this,newsPaperName , Toast.LENGTH_SHORT).show();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsHeadlinesActivity.super.onBackPressed();
            }
        });

    }
}