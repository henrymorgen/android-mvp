package com.example.liuwangshu.moonmvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }
}
