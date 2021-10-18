package com.qubitech.barta.ui.News;

import com.qubitech.barta.R;
import com.qubitech.barta.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsPapersStaticData {

    public static String currentNewspaperIntentARG = "newspaperName";
    public static String detailedNewsIntentARG = "newsDetails";

    private static ArrayList<NewsPaperListDataModel> bengaliNewsPapers = null;
    private static ArrayList<NewsPaperListDataModel> englishNewsPapers = null;
    private static ArrayList<NewsPaperListDataModel> onlineNewsPapers = null;
    private static HashMap<String, String[]> tabs = null;


    /**
     * @return all bengali Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getBengaliNewsPapers() {
        if (bengaliNewsPapers == null) {
            bengaliNewsPapers = new ArrayList<>();
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.prothom_alo, R.drawable.prothomalo, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.ittefaq, R.drawable.ittefaq, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.jugantor, R.drawable.jugantor, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.kalerkontho, R.drawable.kalerkontho, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.amader_shomoy, R.drawable.amader_shomoy, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.inqilab, R.drawable.inqilab, 0));
            bengaliNewsPapers.add(new NewsPaperListDataModel(R.string.bangladesh_pratidin, R.drawable.bangladesh_pratidin, 0));


        }
        return bengaliNewsPapers;

    }

    /**
     * @return all english Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getEnglishNewsPapers() {
        if (englishNewsPapers == null) {

            englishNewsPapers = new ArrayList<>();
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_star, R.drawable.daily_star, 1));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.dhaka_tribune, R.drawable.dhakatribune, 1));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.daily_sun, R.drawable.daily_sun, 1));
            englishNewsPapers.add(new NewsPaperListDataModel(R.string.independent, R.drawable.independent, 1));

        }
        return englishNewsPapers;

    }

    /**
     * @return all online Newspapers {@link ArrayList<NewsPaperListDataModel>}
     */
    public static ArrayList<NewsPaperListDataModel> getOnlineNewsPapers() {
        if (onlineNewsPapers == null) {
            onlineNewsPapers = new ArrayList<>();
            onlineNewsPapers.add(new NewsPaperListDataModel(R.string.bangla_news24, R.drawable.bangla_news_24, 1));
        }
        return onlineNewsPapers;

    }

    /**
     * returns all tabs of a newspaper
     */
    public static HashMap<String, String[]> getTabs() {
        if (tabs == null) {
            tabs = new HashMap<>();
            tabs.put("দৈনিক প্রথম আলো", new String[]{"বাংলাদেশ", "করোনাভাইরাস", "রাজনীতি", "বাণিজ্য", "বিশ্ব", "খেলা", "বিনোদন", "চাকরি", "মতামত"});
            tabs.put("দৈনিক ইত্তেফাক", new String[]{"করোনা আপডেট", "রাজধানী", "জাতীয়", "রাজনীতি", "সারাদেশ", "বিশ্ব সংবাদ", "অর্থনীতি", "খেলা", "বিনোদন", "ভিন্ন চোখে", "লাইফস্টাইল", "আদালত"});
            tabs.put("যুগান্তর", new String[]{"আজকের পত্রিকা", "কোভিড-১৯", "জাতীয়", "রাজনীতি", "সারাদেশ", "অর্থনীতি", "আন্তর্জাতিক", "খেলা", "পরবাস", "শিক্ষাঙ্গন"});
            tabs.put("দৈনিক কালেরকন্ঠ", new String[]{"জাতীয়", "তথ্যপ্রযুক্তি", "পরবাস", "সারাবাংলা", "কর্পোরেটকর্নার", "খেলা", "সারাবিশ্ব", "বাণিজ্য", "বিনোদন"});
            tabs.put("আমাদের সময়", new String[]{"জাতীয়", "রাজনীতি", "বিশেষ সংবাদ", "আমাদের দেশ", "আমাদের প্রযুক্তি", "আমাদের বিশ্ব", "ইন্টারভিউ", "প্রবাসের খবর", "ইসলামি চিন্তা", "চাকরীর খবর", "অফবিট", "অর্থনীতি", "আমাদের কৃষি", "আমাদের খেলা", "তদন্ত প্রতিবেদন", "মিডিয়া ওয়াচ", "সংস্কৃতি", "সন্দেশ",
                    "বিনোদন", "ভিন্ন খবর", "মত-ভিন্নমত", "দক্ষিণ এশিয়ার খবর", "নির্বাচিত কলাম", "পৃথিবীর পথে", "ক্যাম্পাস"});
            tabs.put("দৈনিক ইনকিলাব", new String[]{"জাতীয়", "বাংলাদেশ", "আন্তর্জাতিক", "খেলাধুলা", "বিনোদন", "মহানগর", "সম্পাদকীয়", "ইসলামী বিশ্ব"});
            tabs.put("বাংলাদেশ প্রতিদিন", new String[]{"করোনাভাইরাস", "নগর জীবন", "দেশগ্রাম", "মন্ত্রী কথন", "মাঠে ময়দানে", "জব মার্কেট", "চায়ের দেশ", "ক্যাম্পাস", "মুক্তমঞ্চ", "ইসলাম", "শোবিজ", "ওপার বাংলা", "পরবাস", "পূর্ব-পশ্চিম", "কর্পোরেট কর্নার"});
            tabs.put("The Daily Star", new String[]{"Country", "Environment", "World", "Arts-entertainment", "Business", "Lifestyle", "Opinion", "Satireday", "Shout", "Showbiz", "Sports", "Toggle"});
            tabs.put("Dhaka Tribune", new String[]{"Politics", "Business", "Environment", "World", "Crime", "Education", "Law-rights", "Sport", "Opinion"});
            tabs.put("Bangla News24", new String[]{"জাতীয়", "রাজনীতি", "লাইফস্টাইল", "শিক্ষা", "শিল্প-সাহিত্য", "স্বাস্থ্য", "তথ্যপ্রযুক্তি", "প্রবাসে বাংলাদেশ", "ফিচার", "বিনোদন", "ভারত", "অর্থনীতি-ব্যবসা", "আইন ও আদালত", "আন্তর্জাতিক", "ইসলাম", "খেলা", "চট্টগ্রাম প্রতিদিন"});
            tabs.put("Daily Sun", new String[]{"National", "World", "Economy", "Sports", "Life-style", "Entertainment", "Arts", "Opinion"});
            tabs.put("The Independent", new String[]{"Bangladesh", "Business", "Politics", "World-news", "Art-culture", "Entertainment", "Environment", "Health", "Opinion", "Science-tech", "Sports", "Travel-tourism"});
        }


        return tabs;
    }


}
