package com.nytimesapp.di.module.NetModule;

import android.content.Context;
import com.nytimesapp.di.module.context.ContextModule;
import com.nytimesapp.di.scope.ApplicationContextScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = {ContextModule.class})
public class OkHttpClientModule {
    @ApplicationContextScope
    @Provides
    public OkHttpClient getOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor,ApiKeyInterceptor apiKeyInterceptor){
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(apiKeyInterceptor)
                .build();
    }
    @ApplicationContextScope
    @Provides
    Cache providesCache(File cacheFile){
        return new Cache(cacheFile,10*1000*1000);
    }

    @ApplicationContextScope
    @Provides
    File providesFile(Context context){
        File file = new File(context.getCacheDir(),"HttpCache");
        file.mkdir();
        return file;
    }

    @ApplicationContextScope
    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @ApplicationContextScope
    @Provides
    ApiKeyInterceptor providesRetrofitInterceptor(){
        return new ApiKeyInterceptor();
    }

}
