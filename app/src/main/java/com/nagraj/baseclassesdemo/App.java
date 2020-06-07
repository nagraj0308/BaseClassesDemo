package com.nagraj.baseclassesdemo;

import android.app.Application;

import com.nagraj.baseclassesdemo.di.BaseClassesDemoComponent;
import com.nagraj.baseclassesdemo.di.BaseClassesDemoModule;
import com.nagraj.baseclassesdemo.di.DaggerBaseClassesDemoComponent;

public class App extends Application {

    private static BaseClassesDemoComponent baseClassesDemoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseClassesDemoComponent = DaggerBaseClassesDemoComponent.builder()
                .baseClassesDemoModule(new BaseClassesDemoModule(this)).build();
    }
    public static BaseClassesDemoComponent getComponent() {
        return baseClassesDemoComponent;
    }
}
