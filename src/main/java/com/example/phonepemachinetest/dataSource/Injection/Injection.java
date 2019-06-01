package com.example.phonepemachinetest.dataSource.Injection;

import android.content.Context;

import com.example.phonepemachinetest.dataSource.DataRepository;
import com.example.phonepemachinetest.dataSource.LocalDataSource;
import com.example.phonepemachinetest.dataSource.RemoteDataSource;

public class Injection {
    public static DataRepository provideDataRepository(Context context) {
        return DataRepository.getInstance(context,
                RemoteDataSource.getInstance(context),
                LocalDataSource.getInstance(context));
    }
}
