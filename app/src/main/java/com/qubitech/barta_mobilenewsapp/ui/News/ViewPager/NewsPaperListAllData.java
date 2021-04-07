package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListDataModel;

import java.util.ArrayList;

public class NewsPaperListAllData {


    private static ArrayList<NewsPaperListDataModel> bengaliNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> englishNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> onlineNewsPapers =null;

    public static ArrayList<NewsPaperListDataModel> getBengaliNewsPapers(){
        if(bengaliNewsPapers==null){
            bengaliNewsPapers = new ArrayList<>();


            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.prothom_alo,R.drawable.prothomalo));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.ittefaq,R.drawable.ittefaq));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.jugantor,R.drawable.jugantor));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.kalerkontho,R.drawable.kalerkontho));
          



        }
        return bengaliNewsPapers;

    }  public static ArrayList<NewsPaperListDataModel> getEnglishNewsPapers(){
        if(englishNewsPapers==null){

            englishNewsPapers = new ArrayList<>();
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_star,R.drawable.daily_star));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.dhaka_tribune,R.drawable.dhakatribune));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_sun,R.drawable.daily_sun));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.bangla_news24,R.drawable.bangla_news_24));
        }
        return englishNewsPapers;

    }
    public static ArrayList<NewsPaperListDataModel> getOnlineNewsPapers(){
        if(onlineNewsPapers==null){
            onlineNewsPapers = new ArrayList<>();

        }
        return onlineNewsPapers;

    }
    

}
