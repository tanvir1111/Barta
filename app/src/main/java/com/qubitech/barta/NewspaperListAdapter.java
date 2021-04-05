package com.qubitech.barta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class NewspaperListAdapter extends BaseAdapter {
    Context ctx;
    ArrayList<Integer> imageIds;
    public NewspaperListAdapter(Context context, ArrayList<Integer> images) {
        ctx = context;
        imageIds= images;
    }

    @Override
    public int getCount() {
        return imageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return imageIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view= LayoutInflater.from(ctx).inflate(R.layout.newspapers_child,parent,false);
        ImageView imageView=view.findViewById(R.id.imageView);
        imageView.setImageResource(imageIds.get(position));
        return view;
    }
}
