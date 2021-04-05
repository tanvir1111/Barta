package com.qubitech.barta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NewspapersActivity extends AppCompatActivity {

    GridView gridView;
    int[] images ={R.drawable.prothomalo,R.drawable.jugantor,R.drawable.ittefaq,R.drawable.kalerkontho};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspapers);

        gridView= findViewById(R.id.gridView);



        ArrayList<Integer> imageIds = new ArrayList<>(Arrays.asList(R.drawable.prothomalo,R.drawable.jugantor,R.drawable.ittefaq,R.drawable.kalerkontho));

        gridView.setAdapter(new NewspaperListAdapter(this,imageIds));
        Toast.makeText(this,""+ images.length, Toast.LENGTH_SHORT).show();

    }
}