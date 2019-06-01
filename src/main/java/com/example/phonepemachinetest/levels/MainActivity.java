package com.example.phonepemachinetest.levels;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.phonepemachinetest.R;
import com.example.phonepemachinetest.dataSource.Injection.Injection;
import com.example.phonepemachinetest.game.GameActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter presenter;
    private RecyclerView recyclerView;
    private LevelListAdapter mAdapter;
    private List<LevelModel> levelModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(Injection.provideDataRepository(getApplicationContext()),this);
        presenter.onViewInitialized();
    }

    @Override
    public void showLevels(List<LevelModel> levelList) {

        this.levelModelList = levelList;
        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new LevelListAdapter(levelModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LevelModel levelModel = levelModelList.get(position);
                presenter.onLevelClicked(levelModel);
                Toast.makeText(getApplicationContext(), levelModel.getLevelName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    @Override
    public void openGameForLevel(LevelModel levelModel) {
        Intent gameIntent = new Intent(this, GameActivity.class);
        gameIntent.putExtra("data",levelModel);
    }
}
