package com.nytimesapp.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.nytimesapp.di.module.NetModule.RetrofitModule;
import com.nytimesapp.di.module.context.ContextModule;
import com.nytimesapp.di.scope.ApplicationContextScope;

import dagger.Component;
import retrofit2.Retrofit;

@ApplicationContextScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface AppComponent {
    Context exposeContext();
    Retrofit exposeRetrofit();
}
