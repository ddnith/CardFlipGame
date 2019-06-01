package com.example.phonepemachinetest.levels;

import java.util.List;

public class MainActivityContract {

    interface View{
        void showLevels(List<LevelModel> levelModelList);
        void openGameForLevel(LevelModel levelModel);
    }

    interface Presenter{
        void onLevelClicked(LevelModel levelModel);
        void onViewInitialized();
    }
}
