// Generated by Dagger (https://google.github.io/dagger).
package com.nytimesapp.feature.browse.di.modules;

import com.nytimesapp.feature.browse.data.remote.MostPopularNewsApiService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class MostPopularNewsApiServiceModule_ProvidesMostPopularNewsApiServiceFactory
    implements Factory<MostPopularNewsApiService> {
  private final MostPopularNewsApiServiceModule module;

  private final Provider<Retrofit> retrofitProvider;

  public MostPopularNewsApiServiceModule_ProvidesMostPopularNewsApiServiceFactory(
      MostPopularNewsApiServiceModule module, Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MostPopularNewsApiService get() {
    return proxyProvidesMostPopularNewsApiService(module, retrofitProvider.get());
  }

  public static MostPopularNewsApiServiceModule_ProvidesMostPopularNewsApiServiceFactory create(
      MostPopularNewsApiServiceModule module, Provider<Retrofit> retrofitProvider) {
    return new MostPopularNewsApiServiceModule_ProvidesMostPopularNewsApiServiceFactory(
        module, retrofitProvider);
  }

  public static MostPopularNewsApiService proxyProvidesMostPopularNewsApiService(
      MostPopularNewsApiServiceModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(
        instance.providesMostPopularNewsApiService(retrofit),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
