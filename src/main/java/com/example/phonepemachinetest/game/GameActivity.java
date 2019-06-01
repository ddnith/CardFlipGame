package com.example.phonepemachinetest.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.phonepemachinetest.R;
import com.example.phonepemachinetest.dataSource.Injection.Injection;
import com.example.phonepemachinetest.levels.LevelModel;
import com.example.phonepemachinetest.levels.RecyclerTouchListener;

import java.util.List;

public class GameActivity extends AppCompatActivity implements GameActivityContract.View{

    private GameActivityContract.Presenter presenter;
    private GameAdapter mAdapter;
    private RecyclerView recyclerView;
    private List<String> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        recyclerView = findViewById(R.id.recyclerView);
        LevelModel levelModel =  getIntent().getParcelableExtra("data");
        presenter = new GameActivityPresenter(Injection.provideDataRepository(getApplicationContext()),this);
        presenter.onViewIntialized(levelModel);
    }

    @Override
    public void displayUi(List<String> imgList, int columns) {

        this.imageList = imgList;

        mAdapter = new GameAdapter(imageList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),columns);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String image = imageList.get(position);
                presenter.onImageClicked(image);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void displayTime(int time) {
        //start Time here and show UI
        //Use TimeTask
    }

    @Override
    public void showImage(String firstImageClicked) {

    }

    @Override
    public void hideImages(String firstImageClicked, String secondImageClicked) {

    }

    @Override
    public void removeImages(String firstImageClicked, String secondImageClicked) {

    }

    @Override
    public void showScore(int score) {

    }

    @Override
    public void showGameOverScreen() {

    }
}
