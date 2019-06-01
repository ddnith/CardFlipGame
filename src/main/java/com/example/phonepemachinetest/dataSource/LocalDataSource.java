package com.example.phonepemachinetest.dataSource;

import android.content.Context;

import com.example.phonepemachinetest.levels.LevelModel;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource extends DataSource {

    private static LocalDataSource localDataSource;

    public LocalDataSource(Context context) {
        super(context);
    }

    @Override
    public List<LevelModel> getGameLevelsForDisplay() {
        List<LevelModel> levelModelList = new ArrayList<>();

        LevelModel easy = new LevelModel("EASY",3,2,120 );
        LevelModel normal = new LevelModel("NORMAL",4,3,200 );
        LevelModel hard = new LevelModel("HARD",5,4,270 );

        levelModelList.add(easy);
        levelModelList.add(normal);
        levelModelList.add(hard);

        return levelModelList;
    }

    public static synchronized LocalDataSource getInstance(Context context) {
        if (localDataSource == null) {
            localDataSource = new LocalDataSource(context.getApplicationContext());
        }
        return localDataSource;
    }

    public List<String> getImagesForDisplay(int imageCount) {
        return null;
    }
}
