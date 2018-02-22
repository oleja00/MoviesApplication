package com.company.my.moviesapplication.presentation.activity_main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.presentation.common.BaseActivity;

public class MainActivity extends BaseActivity {

    public static void run(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
