package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.NewsHeadlinesActivity;
import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewspaperViewModel;

import java.util.List;

import static com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData.currentNewspaperIntentARG;

public class NewsPaperListAdapter  extends RecyclerView.Adapter<NewsPaperListViewHolder> {
    private final Context ctx;
    private final List<NewsPaperListDataModel> newsPaperListDataModels;
    private final NewspaperViewModel newspaperViewModel;


    /**
     * gets arraylist and sets to recyclerview
     * observes arraylist in viewmodel
     * @param ctx
     * @param newsPaperListDataModels
     * @param newspaperViewModel
     */
    public NewsPaperListAdapter(Context ctx, List<NewsPaperListDataModel> newsPaperListDataModels,NewspaperViewModel newspaperViewModel) {
        this.ctx = ctx;
        this.newsPaperListDataModels = newsPaperListDataModels;
        this.newspaperViewModel=newspaperViewModel;
    }

    @NonNull
    @Override
    public NewsPaperListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.newspaper_list_child,parent,false);
        return new NewsPaperListViewHolder(view);
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
                Pair[] pairs=new Pair[1];
                pairs[0]=new Pair<View,String>(holder.newspaperName,holder.newspaperName.getTransitionName());
                ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) ctx,pairs);
//                NewsPaperListAllData.currentNewspaper = newsPaperName;
                ctx.startActivity(intent,options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsPaperListDataModels.size();
    }
}
