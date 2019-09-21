package com.nytimesapp.util;

import android.app.Application;

import com.nytimesapp.BuildConfig;
import com.nytimesapp.di.component.AppComponent;
import com.nytimesapp.di.component.DaggerAppComponent;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule;
import com.nytimesapp.di.module.NetModule.RetrofitModule;
import com.nytimesapp.di.module.context.ContextModule;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class MyApp extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().contextModule(new ContextModule(getApplicationContext()))
                .okHttpClientModule(new OkHttpClientModule())
                .retrofitModule(new RetrofitModule()).build();

        Picasso.setSingletonInstance(new Picasso.Builder(this).build());
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }

}
