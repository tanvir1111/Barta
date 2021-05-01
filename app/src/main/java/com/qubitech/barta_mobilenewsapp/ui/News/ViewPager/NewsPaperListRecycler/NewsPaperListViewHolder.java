package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.R;

public class NewsPaperListViewHolder extends RecyclerView.ViewHolder {
    public TextView newspaperName;
    public ImageView newsImg;

    public NewsPaperListViewHolder(@NonNull View itemView) {
        super(itemView);
        newspaperName= itemView.findViewById(R.id.newspaper_name);
        newsImg  = itemView.findViewById(R.id.newspaper_child_image);
    }
}
