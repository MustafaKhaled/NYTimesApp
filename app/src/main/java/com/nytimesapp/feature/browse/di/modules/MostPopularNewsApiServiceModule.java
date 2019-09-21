package com.nytimesapp.feature.browse.di.modules;

import com.nytimesapp.feature.browse.data.remote.MostPopularNewsApiService;
import com.nytimesapp.feature.browse.di.scope.MostPopularNewsScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
@Module
public class MostPopularNewsApiServiceModule {
    @MostPopularNewsScope
    @Provides
    public MostPopularNewsApiService providesMostPopularNewsApiService(Retrofit retrofit) {
        return retrofit.create(MostPopularNewsApiService.class);

    }
}
