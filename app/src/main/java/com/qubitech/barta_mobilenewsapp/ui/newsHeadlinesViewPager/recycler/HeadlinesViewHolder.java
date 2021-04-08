package com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.R;

public class HeadlinesViewHolder extends RecyclerView.ViewHolder {
    public TextView headline;
    public ImageView headlineImg;

    public HeadlinesViewHolder(@NonNull View itemView) {
        super(itemView);
        headline= itemView.findViewById(R.id.news_headline);
        headlineImg  = itemView.findViewById(R.id.news_headlines_image);
    }
}