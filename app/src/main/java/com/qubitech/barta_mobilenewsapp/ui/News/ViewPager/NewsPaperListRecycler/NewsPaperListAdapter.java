package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.NewsHeadlinesActivity;
import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewspaperViewModel;

import java.util.List;

import static com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData.currentNewspaperIntentARG;

public class NewsPaperListAdapter  extends RecyclerView.Adapter<NewsPaperListViewHolder> {
    Context ctx;
    List<NewsPaperListDataModel> newsPaperListDataModels;
    NewspaperViewModel newspaperViewModel;



    public NewsPaperListAdapter(Context ctx, List<NewsPaperListDataModel> newsPaperListDataModels,NewspaperViewModel newspaperViewModel) {
        this.ctx = ctx;
        this.newsPaperListDataModels = newsPaperListDataModels;
        this.newspaperViewModel=newspaperViewModel;
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

        NewsPaperListDataModel newsPaper=newsPaperListDataModels.get(position);
        String newsPaperName = ctx.getString(newsPaper.getNameID());


        holder.newsImg.setImageResource(newsPaper.getImageID());
        holder.newspaperName.setText(newsPaperName);

        newspaperViewModel.getFavorites(newsPaper.getNewspaperType()).observe((LifecycleOwner) ctx, new Observer<List<NewsPaperListDataModel>>() {
            @Override
            public void onChanged(List<NewsPaperListDataModel> newsPaperList) {
                for (NewsPaperListDataModel item: newsPaperList) {
                    if(item.getNameID()==newsPaper.getNameID()){
                        holder.favoriteBtn.setImageResource(R.drawable.star_selected);
                    }
                }
            }
        });


        holder.favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID =newsPaper.getNameID();
                if(newspaperViewModel.getNewspaper(ID)==null){
                    newspaperViewModel.insert(newsPaper);
                }
                else {
                    newspaperViewModel.delete(newsPaper);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, NewsHeadlinesActivity.class);
                intent.putExtra(currentNewspaperIntentARG,newsPaperName);
//                NewsPaperListAllData.currentNewspaper = newsPaperName;
                ctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsPaperListDataModels.size();
    }
}
