package com.example.phonepemachinetest.dataSource;

import android.content.Context;

import com.example.phonepemachinetest.levels.LevelModel;

import java.util.List;

public abstract class DataSource {
    public DataSource(Context context) {

    }

    public abstract List<LevelModel> getGameLevelsForDisplay();
}
