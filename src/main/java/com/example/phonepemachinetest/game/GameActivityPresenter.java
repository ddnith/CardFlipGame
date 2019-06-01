package com.example.phonepemachinetest.game;

import com.example.phonepemachinetest.dataSource.DataRepository;
import com.example.phonepemachinetest.levels.LevelModel;

import java.util.Collections;
import java.util.List;

public class GameActivityPresenter implements GameActivityContract.Presenter{

    private DataRepository dataRepository;
    private GameActivityContract.View view;

    private List<String> imagePathList;

    private LevelModel levelModel;

    private String firstImageClicked;
    private String secondImageClicked;
    private int Score = 0;
    private int timeLeft;

    public GameActivityPresenter(DataRepository dataRepository, GameActivityContract.View view) {
        this.dataRepository = dataRepository;
        this.view = view;
    }

    @Override
    public void onViewIntialized(LevelModel levelModel) {
        this.levelModel = levelModel;
        int rows = levelModel.getLevelRows();
        int columns = levelModel.getLevelColumns();
        int imageCount = rows * columns /2;
        List<String> imageList = dataRepository.getImagesForDisplay(imageCount);
        Collections.shuffle(imageList);
        imagePathList = imageList;
        if(view != null){
            timeLeft = levelModel.getTimeForPlay();
            view.displayTime(levelModel.getTimeForPlay());
            view.displayUi(imagePathList,columns );
        }

    }

    @Override
    public void onImageClicked(String image) {
        if(firstImageClicked == null){
            firstImageClicked = image;
            if(view != null){
                view.showImage(firstImageClicked);
            }
        }else if(secondImageClicked == null){
            if(view != null){
                view.showImage(secondImageClicked);
            }
            if(firstImageClicked.equals(secondImageClicked)){
                view.removeImages(firstImageClicked,secondImageClicked);
                Score += 10;
            }
        }else {
            if(view != null){
                view.hideImages(firstImageClicked,secondImageClicked);
                firstImageClicked = image;
                if(view != null){
                    view.showImage(firstImageClicked);
                }
                secondImageClicked = null;
            }
        }
        if(noImagesLeft()){
            Score += timeLeft;
            if(view!= null){
                view.showScore(Score);
            }
        }
    }

    @Override
    public void updateTime(int time) {
        timeLeft = time;
    }

    @Override
    public void onTimeUp() {
        if(view != null){
            view.showGameOverScreen();
        }
    }

    private boolean noImagesLeft() {
        return false;
    }
}
