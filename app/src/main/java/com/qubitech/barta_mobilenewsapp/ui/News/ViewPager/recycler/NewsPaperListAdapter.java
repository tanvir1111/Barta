package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.NewsHeadlinesActivity;
import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListAllData;

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
        String newsPaperName = ctx.getString(newsPaperListDataModels.get(position).getNewspaperNameID());
        holder.newsImg.setImageResource(newsPaperListDataModels.get(position).getImageId());
        holder.newspaperName.setText(newsPaperName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, NewsHeadlinesActivity.class);
                intent.putExtra("NewspaperName",newsPaperName);
                NewsPaperListAllData.currentNewspaper = newsPaperName;
                ctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsPaperListDataModels.size();
    }
}
