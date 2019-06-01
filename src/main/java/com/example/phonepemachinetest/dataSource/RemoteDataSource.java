package com.example.phonepemachinetest.dataSource;

import android.content.Context;

import com.example.phonepemachinetest.levels.LevelModel;

import java.util.List;

public class RemoteDataSource extends DataSource{

    private static RemoteDataSource remoteDataSource;

    private RemoteDataSource(Context context) {
        super(context);
    }

    @Override
    public List<LevelModel> getGameLevelsForDisplay() {
        return null;
    }

    public static synchronized RemoteDataSource getInstance(Context context) {
        if (remoteDataSource == null) {
            remoteDataSource = new RemoteDataSource(context.getApplicationContext());
        }
        return remoteDataSource;
    }
}
