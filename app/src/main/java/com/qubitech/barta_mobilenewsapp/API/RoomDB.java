package com.qubitech.barta_mobilenewsapp.API;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.qubitech.barta_mobilenewsapp.ui.News.ViewPager.NewsPaperListRecycler.NewsPaperListDataModel;
import com.qubitech.barta_mobilenewsapp.ui.NewsHeadlinesViewPager.HeadlinesRecycler.HeadlinesDataModel;

@Database(entities = {HeadlinesDataModel.class, NewsPaperListDataModel.class}, version = 4, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    private static RoomDB database;

    private static String DATABASE_NAME = "user_data";

    /**
     * @param context
     * @return RoomDB
     */
    public synchronized static RoomDB getInstance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }


    /**
     * returns data access object
     *
     * @return {@link UserDao}
     */
    public abstract UserDao userDao();

}
