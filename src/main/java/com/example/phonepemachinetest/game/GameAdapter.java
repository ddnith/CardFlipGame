package com.example.phonepemachinetest.game;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepemachinetest.R;
import com.example.phonepemachinetest.levels.LevelListAdapter;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<String>  imagePath;

    public GameAdapter(List<String> imagePath) {
        this.imagePath = imagePath;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder gameViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {
        public TextView levelName;

        public GameViewHolder(View view) {
            super(view);
            levelName =  view.findViewById(R.id.levelName);
        }
    }
}
