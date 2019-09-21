package com.nytimesapp.di.module.context;

import android.content.Context;

import com.nytimesapp.di.scope.ApplicationContextScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }
    @ApplicationContextScope
    @Provides
    Context providesContext(){
        return context;
    }
}
