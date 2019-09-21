package com.nytimesapp.feature.browse.data.repo;

import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;
import com.nytimesapp.feature.browse.data.remote.MostPopularNewsApiService;

import javax.inject.Inject;

import io.reactivex.Single;

public class MostPopularNewsRepository {
    private MostPopularNewsApiService apiService;
    @Inject
    public MostPopularNewsRepository(MostPopularNewsApiService apiService) {
        this.apiService = apiService;
    }

    public Single<MostPopularNewsResponse> requestMostPopularNews(int period){
       return apiService.requestMostPopularNews(period);
    }
}
