package com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.qubitech.barta_mobilenewsapp.DetailedNewsActivity;
import com.qubitech.barta_mobilenewsapp.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.qubitech.barta_mobilenewsapp.ui.News.NewsPapersStaticData.detailedNewsIntentARG;

public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesViewHolder> {
    private Context ctx;
    private List<HeadlinesDataModel> headlinesList;
    public HeadlinesAdapter(Context ctx, List<HeadlinesDataModel> headlinesList) {
        this.ctx = ctx;
        this.headlinesList = headlinesList;
    }

    @NonNull
    @Override
    public HeadlinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.news_headlines_child,parent,false);
        HeadlinesViewHolder nvh=new HeadlinesViewHolder(view);
        return nvh;
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesViewHolder holder, int position) {
        String headline = headlinesList.get(position).getHeadline();

        String imageUrl = headlinesList.get(position).getImageUrl();
        if(imageUrl==null){
            holder.headlineImg.setImageResource(R.drawable.image_failed);
        }
        else if(imageUrl.isEmpty()){
            holder.headlineImg.setImageResource(R.drawable.image_failed);
        }
        else {
            Picasso.get().load(imageUrl).into(holder.headlineImg, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    holder.headlineImg.setImageResource(R.drawable.image_failed);

                }
            });
        }
        holder.headline.setText(headline);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            /**
             * sends to {@link DetailedNewsActivity } with news
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailedNewsActivity.class);
                CardView cardView =holder.itemView.findViewById(R.id.news_image_card);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(holder.headline,holder.headline.getTransitionName());
                pairs[1]=new Pair<View,String>(cardView,cardView.getTransitionName());
                ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) ctx,pairs);
                intent.putExtra(detailedNewsIntentARG, headlinesList.get(position));
                ctx.startActivity(intent,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(headlinesList ==null){
            return 0;
        }
        return headlinesList.size();
    }
}
