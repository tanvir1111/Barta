package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.R;

import java.util.ArrayList;

public class NewsPaperListAdapter  extends RecyclerView.Adapter<NewsPaperListViewHolder> {
    Context ctx;
    ArrayList<NewsPaperListDataModel> newsPaperListDataModels;

    public NewsPaperListAdapter(Context ctx, ArrayList<NewsPaperListDataModel> newsPaperListDataModels) {
        this.ctx = ctx;
        this.newsPaperListDataModels = newsPaperListDataModels;
    }

    @NonNull
    @Override
    public NewsPaperListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.newspaper_list_child,parent,false);
        NewsPaperListViewHolder nvh=new NewsPaperListViewHolder(view);
        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsPaperListViewHolder holder, int position) {
        holder.newsImg.setImageResource(newsPaperListDataModels.get(position).getImageId());
        holder.newspaperName.setText(ctx.getString(newsPaperListDataModels.get(position).getNewspaperName()));

    }

    @Override
    public int getItemCount() {
        return newsPaperListDataModels.size();
    }
}
