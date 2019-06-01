package com.example.phonepemachinetest.levels;

import com.example.phonepemachinetest.dataSource.DataRepository;

import java.util.List;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private DataRepository dataRepository;
    private MainActivityContract.View view;


    public MainActivityPresenter(DataRepository dataRepository, MainActivityContract.View view) {
        this.dataRepository = dataRepository;
        this.view = view;
    }

    @Override
    public void onLevelClicked(LevelModel levelModel) {
        if(view != null){
            view.openGameForLevel(levelModel);
        }
    }

    @Override
    public void onViewInitialized() {
        List<LevelModel> levelModels =  dataRepository.getGameLevelsForDisplay();
        if(view != null){
            view.showLevels(levelModels);
        }
    }
}
