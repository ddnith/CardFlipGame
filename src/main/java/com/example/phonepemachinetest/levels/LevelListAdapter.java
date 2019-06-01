package com.example.phonepemachinetest.levels;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phonepemachinetest.R;

import java.util.List;
import java.util.logging.Level;

public class LevelListAdapter extends RecyclerView.Adapter<LevelListAdapter.LevelViewHolder> {

    private List<LevelModel> levelList;

    public LevelListAdapter(List<LevelModel> levelList) {
        this.levelList = levelList;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_level_row, parent, false);

        return new LevelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder levelViewHolder, int i) {
        LevelModel levelModel = levelList.get(i);
        levelViewHolder.levelName.setText(levelModel.getLevelName());
    }

    @Override
    public int getItemCount() {
        if(levelList != null)
            levelList.size();
        return 0;
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder {
        public TextView levelName;

        public LevelViewHolder(View view) {
            super(view);
            levelName =  view.findViewById(R.id.levelName);
        }
    }

}
