package com.qubitech.barta_mobilenewsapp.Repository;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {

    private final Application application;
    private final FirebaseFirestore db;
    private MutableLiveData<List<HeadlinesDataModel>> headlines;

    /**
     * @param application
     */
    public NewsRepository(Application application) {
        this.application = application;
        headlines = new MutableLiveData<>();
        db = FirebaseFirestore.getInstance();

    }


    /**
     * returns all news
     *
     * @param newspaperName
     * @param newsCategory
     * @return {@link LiveData<List<HeadlinesDataModel>>}
     */
    public LiveData<List<HeadlinesDataModel>> getAllNews(String newspaperName, String newsCategory) {
        fetchNews(newspaperName, newsCategory);
        return headlines;
    }


    /**
     * gets data from firestore and sets livedata
     *
     * @param newspaperName
     * @param newsCategory
     */
    private void fetchNews(String newspaperName, String newsCategory) {
        ArrayList<HeadlinesDataModel> headlinesArrayList = new ArrayList<>();

        db.collection("News").document(newspaperName).collection(newsCategory)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        HeadlinesDataModel headline = document.toObject(HeadlinesDataModel.class);
                        headlinesArrayList.add(headline);

                    }
                    headlines.setValue(headlinesArrayList);
                } else {
                    Toast.makeText(application, "failed", Toast.LENGTH_SHORT).show();

                }
            }
        });


//        RetroInterface retroInterface = RestClient.getRestClient();
//        Call<ArrayList<HeadlinesDataModel>> call = retroInterface.getNews(new HeadlinesDataModel(newspaperName,newsCategory));
//        call.enqueue(new Callback<ArrayList<HeadlinesDataModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<HeadlinesDataModel>> call, Response<ArrayList<HeadlinesDataModel>> response) {
//                if (response.isSuccessful()) {
//                    headlines.setValue(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<HeadlinesDataModel>> call, Throwable t) {
//                Toast.makeText(application.getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
