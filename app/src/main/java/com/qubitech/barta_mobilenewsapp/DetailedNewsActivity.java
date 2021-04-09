package com.qubitech.barta_mobilenewsapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;

public class DetailedNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.appbar_with_back);
        getSupportActionBar().setElevation(10);
        View view = getSupportActionBar().getCustomView();
        TextView title = view.findViewById(R.id.appbar_title);
        TextView section = findViewById(R.id.section_name);
        ImageView backBtn = view.findViewById(R.id.appbar_back_btn);
        title.setText(NewsPaperListAllData.currentNewspaper);
        section.setText(NewsPaperListAllData.currentNewspaperSection);

        Toast.makeText(this, NewsPaperListAllData.currentNewspaperSection, Toast.LENGTH_SHORT).show();


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailedNewsActivity.super.onBackPressed();
            }
        });
    }
}