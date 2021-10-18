package com.qubitech.barta.ui.News.ViewPager.NewsPaperListRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta.R;

public class NewsPaperListViewHolder extends RecyclerView.ViewHolder {
    TextView newspaperName;
    ImageView newsImg;
    ImageView favoriteBtn;

    public NewsPaperListViewHolder(@NonNull View itemView) {
        super(itemView);
        newspaperName = itemView.findViewById(R.id.newspaper_name);
        newsImg = itemView.findViewById(R.id.newspaper_child_image);
        favoriteBtn = itemView.findViewById(R.id.newspaper_child_star);
    }
}
