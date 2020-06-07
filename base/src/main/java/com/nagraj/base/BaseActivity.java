package com.nagraj.base;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initDependencies();
        initViews();
        onReady();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    public static <T extends Comparable<T>> T log(T x) {
        Log.v("NAGRAJ",String.valueOf(x));
        return null;
    }

    protected abstract void initDependencies();

    protected abstract void initViews();

    protected abstract void onReady();
}