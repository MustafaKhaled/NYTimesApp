package com.nytimesapp.feature.browse.data.remote;

import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MostPopularNewsApiService {

    @GET("viewed/{period}.json")
    Single<MostPopularNewsResponse> requestMostPopularNews(@Path("period") int period);
}
