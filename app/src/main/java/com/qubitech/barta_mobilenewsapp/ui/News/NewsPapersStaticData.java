package com.qubitech.barta_mobilenewsapp.ui.News;

import com.qubitech.barta_mobilenewsapp.R;
import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsPapersStaticData {

    public static String currentNewspaperIntentARG = "newspaperName";
    public static String detailedNewsIntentARG = "newsDetails";

    private static ArrayList<NewsPaperListDataModel> bengaliNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> englishNewsPapers =null;
    private static ArrayList<NewsPaperListDataModel> onlineNewsPapers =null;
    private static HashMap<String, String[]> tabs =null;


    /**
     * @return all bengali Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getBengaliNewsPapers(){
        if(bengaliNewsPapers==null){
            bengaliNewsPapers = new ArrayList<>();
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.prothom_alo,R.drawable.prothomalo,0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.ittefaq,R.drawable.ittefaq,0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.jugantor,R.drawable.jugantor,0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.kalerkontho,R.drawable.kalerkontho,0));
          



        }
        return bengaliNewsPapers;

    }

    /**
     * @return all english Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getEnglishNewsPapers(){
        if(englishNewsPapers==null){

            englishNewsPapers = new ArrayList<>();
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_star,R.drawable.daily_star,1));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.dhaka_tribune,R.drawable.dhakatribune,1));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_sun,R.drawable.daily_sun,1));

            englishNewsPapers.add(new NewsPaperListDataModel(R.string.bangladesh_today,R.drawable.bangla_news_24,1));
        }
        return englishNewsPapers;

    }

    /**
     * @return all online Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getOnlineNewsPapers(){
        if(onlineNewsPapers==null){
            onlineNewsPapers = new ArrayList<>();
            onlineNewsPapers.add(new NewsPaperListDataModel(R.string.bangla_news24,R.drawable.bangla_news_24,1));
        }
        return onlineNewsPapers;

    }

    /**
     * returns all tabs of a newspaper
     */
    public static HashMap<String,String[]> getTabs(){
        if (tabs==null){
            tabs=new HashMap<>();
            tabs.put("দৈনিক প্রথম আলো",new String[] { "বাংলাদেশ","করোনাভাইরাস","রাজনীতি", "বাণিজ্য","বিশ্ব","খেলা","বিনোদন", "চাকরি","মতামত"});
            tabs.put("দৈনিক ইত্তেফাক",new String[] {"করোনা আপডেট","রাজধানী","জাতীয়","রাজনীতি","সারাদেশ","বিশ্ব সংবাদ","অর্থনীতি","খেলা","বিনোদন","ভিন্ন চোখে","লাইফস্টাইল","আদালত"});
            tabs.put("যুগান্তর",new String[] {"অর্থনীতি","আজকের পত্রিকা","আন্তর্জাতিক","কোভিড-১৯","খেলা","জাতীয়","পরবাস","রাজনীতি", "শিক্ষাঙ্গন","সারাদেশ"});
            tabs.put("দৈনিক কালেরকন্ঠ",new String[] {"জাতীয়","সারাবাংলা","সারাবিশ্ব","খেলা","বাণিজ্য","বিনোদন"});
            tabs.put("The Daily Star",new String[] {"Country","Environment", "World","Arts-entertainment","Business","Lifestyle","Opinion","Satireday","Shout","Showbiz","Sports","Toggle"});
            tabs.put("Dhaka Tribune",new String[] {"National", "Politics", "Dhaka Tribune"});
            tabs.put("Bangla News24",new String[] {"National", "Politics", "Bangla News24"});
            tabs.put("Daily Sun",new String[] {"National","World","Economy","Sports","Life-style","Entertainment","Arts","Opinion"});
            tabs.put("Bangladesh Today",new String[]{
                    "Business","Campus","Development","Editorial","National","Nationwide" ,"Politics","Sports","Technology","Entertainment", "Environment", "Health","International"});

        }


        return tabs;
    }



}
