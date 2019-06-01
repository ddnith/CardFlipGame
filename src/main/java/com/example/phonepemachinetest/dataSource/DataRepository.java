package com.example.phonepemachinetest.dataSource;

import android.content.Context;

import com.example.phonepemachinetest.levels.LevelModel;

import java.util.List;

public class DataRepository {

    private static DataRepository dataRepository;
    private final Context mContext;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;

    private DataRepository(Context context, RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.mContext = context.getApplicationContext();
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static synchronized DataRepository getInstance(Context context, RemoteDataSource remoteDataSource,
                                                          LocalDataSource localDataSource) {
        if (dataRepository == null) {
            dataRepository = new DataRepository(context, remoteDataSource, localDataSource);
        }
        return dataRepository;
    }

    public List<LevelModel> getGameLevelsForDisplay() {
        return localDataSource.getGameLevelsForDisplay();
    }

    public List<String> getImagesForDisplay(int imageCount) {
        return localDataSource.getImagesForDisplay(imageCount);
    }
}
