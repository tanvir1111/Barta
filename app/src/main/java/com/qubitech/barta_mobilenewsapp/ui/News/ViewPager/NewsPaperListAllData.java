package com.qubitech.barta_mobilenewsapp.ui.News.ViewPager;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.recycler.NewsPaperListDataModel;
import com.qubitech.barta_mobilenewsapp.ui.newsHeadlinesViewPager.recycler.HeadlinesDataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsPaperListAllData {


    private static ArrayList<NewsPaperListDataModel> bengaliNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> englishNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> onlineNewsPapers =null;
    private static HashMap<String, String[]> tabs =null;
    private static ArrayList<HeadlinesDataModel> headlinesDataModels =null;

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
    public static HashMap<String,String[]> getTabs(){
        if (tabs==null){
            tabs=new HashMap<>();
            tabs.put("দৈনিক প্রথম আলো",new String[] {"জাতীয়", "রাজনীতি", "প্রথম আলো"});
            tabs.put("দৈনিক ইত্তেফাক",new String[] {"জাতীয়", "রাজনীতি", "ইত্তেফাক"});
            tabs.put("দৈনিক যুগান্তর",new String[] {"জাতীয়", "রাজনীতি", "যুগান্তর"});
            tabs.put("দৈনিক কালেরকন্ঠ",new String[] {"জাতীয়", "রাজনীতি", "কালেরকন্ঠ"});
            tabs.put("The Daily Star",new String[] {"National", "Politics", "Daily Star"});
            tabs.put("Dhaka Tribune",new String[] {"National", "Politics", "Dhaka Tribune"});
            tabs.put("Bangla News24",new String[] {"National", "Politics", "Bangla News24"});
            tabs.put("Daily Sun",new String[] {"National", "Politics", "Daily Sun"});

        }


        return tabs;
    }


    public static ArrayList<HeadlinesDataModel> getHeadlines() {
        if(headlinesDataModels==null){
            headlinesDataModels = new ArrayList<>();


            headlinesDataModels.add(new HeadlinesDataModel("abc","abc"));
            headlinesDataModels.add(new HeadlinesDataModel("abc","abc"));
            headlinesDataModels.add(new HeadlinesDataModel("abc","abc"));
            headlinesDataModels.add(new HeadlinesDataModel("abc","abc"));




        }
        return headlinesDataModels;
    }
}
