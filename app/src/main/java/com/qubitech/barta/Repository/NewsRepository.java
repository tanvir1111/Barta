package com.qubitech.barta.Repository;

import android.app.Application;
import android.text.format.DateUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.qubitech.barta.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewsRepository {

    private final Application application;
    private final FirebaseFirestore db;
    private MutableLiveData<List<HeadlinesDataModel>> headlines;
    private ArrayList<String> dates =new ArrayList<>();


    /**
     * @param application
     */
    public NewsRepository(Application application) {
        this.application = application;
        headlines = new MutableLiveData<>();
        headlines.setValue(new ArrayList<>());
        db = FirebaseFirestore.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal =Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        dates.add(sdf.format(new Date()));

        dates.add(sdf.format(cal.getTime()));
        cal.add(Calendar.DATE,-1);
        dates.add(sdf.format(cal.getTime()));


    }


    /**
     * returns all news
     *
     * @param newspaperName
     * @param newsCategory
     * @return {@link LiveData<List<HeadlinesDataModel>>}
     */
    public LiveData<List<HeadlinesDataModel>> getAllNews(String newspaperName, String newsCategory) {
        if(headlines.getValue().size()==0) {
            for (int i = 0; i < dates.size(); i++) {
                fetchNews(newspaperName, newsCategory, dates.get(i));
            }
        }
//        fetchNews(newspaperName, newsCategory);
        return headlines;
    }


    /**
     * gets data from firestore and sets livedata
     *
     * @param newspaperName
     * @param newsCategory
     */
    private void fetchNews(String newspaperName, String newsCategory,String date) {
        ArrayList<HeadlinesDataModel> headlinesArrayList = (ArrayList<HeadlinesDataModel>) headlines.getValue();
        db.collection(newspaperName).document(newsCategory).collection("news")
                .whereEqualTo("date",date).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        HeadlinesDataModel headline = document.toObject(HeadlinesDataModel.class);
                        if(!headlines.getValue().contains(headline))
                            headlinesArrayList.add(headline);


                    }
                    headlines.setValue(headlinesArrayList);
                } else {
                    Toast.makeText(application, "failed", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
