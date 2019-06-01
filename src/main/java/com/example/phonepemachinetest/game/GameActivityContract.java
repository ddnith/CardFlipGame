package com.example.phonepemachinetest.game;

import com.example.phonepemachinetest.levels.LevelModel;

import java.util.List;

public class GameActivityContract {

    interface View{
        void displayUi(List<String> imageList, int columns);
        void displayTime(int time);

        void showImage(String firstImageClicked);

        void hideImages(String firstImageClicked, String secondImageClicked);

        void removeImages(String firstImageClicked, String secondImageClicked);

        void showScore(int score);

        void showGameOverScreen();
    }

    interface Presenter{
        void onViewIntialized(LevelModel levelModel);

        void onImageClicked(String image);

        void updateTime(int time);

        void onTimeUp();
    }
}
