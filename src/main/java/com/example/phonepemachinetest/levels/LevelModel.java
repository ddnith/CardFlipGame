package com.example.phonepemachinetest.levels;

import android.os.Parcel;
import android.os.Parcelable;

public class LevelModel implements Parcelable {
    String levelName;
    int levelRows;
    int levelColumns;
    int timeForPlay;

    public LevelModel(String levelName, int levelRows, int levelColumns, int timeForPlay) {
        this.levelName = levelName;
        this.levelRows = levelRows;
        this.levelColumns = levelColumns;
        this.timeForPlay = timeForPlay;
    }

    public LevelModel(Parcel parcel){
        levelName = parcel.readString();
        levelRows = parcel.readInt();
        levelColumns = parcel.readInt();
        timeForPlay = parcel.readInt();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLevelRows() {
        return levelRows;
    }

    public void setLevelRows(int levelRows) {
        this.levelRows = levelRows;
    }

    public int getLevelColumns() {
        return levelColumns;
    }

    public void setLevelColumns(int levelColumns) {
        this.levelColumns = levelColumns;
    }

    public int getTimeForPlay() {
        return timeForPlay;
    }

    public void setTimeForPlay(int timeForPlay) {
        this.timeForPlay = timeForPlay;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(levelName);
        dest.writeInt(levelRows);
        dest.writeInt(levelColumns);
        dest.writeInt(timeForPlay);
    }

    public static final Parcelable.Creator<LevelModel> CREATOR = new Parcelable.Creator<LevelModel>() {
        public LevelModel createFromParcel(Parcel in) {
            return new LevelModel(in);
        }

        @Override
        public LevelModel[] newArray(int size) {
            return new LevelModel[0];
        }
    };
}
