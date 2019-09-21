// Generated by Dagger (https://google.github.io/dagger).
package com.nytimesapp.di.component;

import android.content.Context;
import com.google.gson.Gson;
import com.nytimesapp.di.module.NetModule.ApiKeyInterceptor;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule_GetHttpLoggingInterceptorFactory;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule_GetOkHttpClientFactory;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule_ProvidesCacheFactory;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule_ProvidesFileFactory;
import com.nytimesapp.di.module.NetModule.OkHttpClientModule_ProvidesRetrofitInterceptorFactory;
import com.nytimesapp.di.module.NetModule.RetrofitModule;
import com.nytimesapp.di.module.NetModule.RetrofitModule_ProvidesGsonConverterFactoryFactory;
import com.nytimesapp.di.module.NetModule.RetrofitModule_ProvidesGsonFactory;
import com.nytimesapp.di.module.NetModule.RetrofitModule_RetrofitFactory;
import com.nytimesapp.di.module.context.ContextModule;
import com.nytimesapp.di.module.context.ContextModule_ProvidesContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DaggerAppComponent implements AppComponent {
  private Provider<Context> providesContextProvider;

  private Provider<File> providesFileProvider;

  private Provider<Cache> providesCacheProvider;

  private Provider<HttpLoggingInterceptor> getHttpLoggingInterceptorProvider;

  private Provider<ApiKeyInterceptor> providesRetrofitInterceptorProvider;

  private Provider<OkHttpClient> getOkHttpClientProvider;

  private Provider<Gson> providesGsonProvider;

  private Provider<GsonConverterFactory> providesGsonConverterFactoryProvider;

  private Provider<Retrofit> retrofitProvider;

  private DaggerAppComponent(
      ContextModule contextModuleParam,
      RetrofitModule retrofitModuleParam,
      OkHttpClientModule okHttpClientModuleParam) {

    initialize(contextModuleParam, retrofitModuleParam, okHttpClientModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(
      final ContextModule contextModuleParam,
      final RetrofitModule retrofitModuleParam,
      final OkHttpClientModule okHttpClientModuleParam) {
    this.providesContextProvider =
        DoubleCheck.provider(ContextModule_ProvidesContextFactory.create(contextModuleParam));
    this.providesFileProvider =
        DoubleCheck.provider(
            OkHttpClientModule_ProvidesFileFactory.create(
                okHttpClientModuleParam, providesContextProvider));
    this.providesCacheProvider =
        DoubleCheck.provider(
            OkHttpClientModule_ProvidesCacheFactory.create(
                okHttpClientModuleParam, providesFileProvider));
    this.getHttpLoggingInterceptorProvider =
        DoubleCheck.provider(
            OkHttpClientModule_GetHttpLoggingInterceptorFactory.create(okHttpClientModuleParam));
    this.providesRetrofitInterceptorProvider =
        DoubleCheck.provider(
            OkHttpClientModule_ProvidesRetrofitInterceptorFactory.create(okHttpClientModuleParam));
    this.getOkHttpClientProvider =
        DoubleCheck.provider(
            OkHttpClientModule_GetOkHttpClientFactory.create(
                okHttpClientModuleParam,
                providesCacheProvider,
                getHttpLoggingInterceptorProvider,
                providesRetrofitInterceptorProvider));
    this.providesGsonProvider =
        DoubleCheck.provider(RetrofitModule_ProvidesGsonFactory.create(retrofitModuleParam));
    this.providesGsonConverterFactoryProvider =
        DoubleCheck.provider(
            RetrofitModule_ProvidesGsonConverterFactoryFactory.create(
                retrofitModuleParam, providesGsonProvider));
    this.retrofitProvider =
        DoubleCheck.provider(
            RetrofitModule_RetrofitFactory.create(
                retrofitModuleParam,
                getOkHttpClientProvider,
                providesGsonProvider,
                providesGsonConverterFactoryProvider));
  }

  @Override
  public Context exposeContext() {
    return providesContextProvider.get();
  }

  @Override
  public Retrofit exposeRetrofit() {
    return retrofitProvider.get();
  }

  public static final class Builder {
    private ContextModule contextModule;

    private RetrofitModule retrofitModule;

    private OkHttpClientModule okHttpClientModule;

    private Builder() {}

    public Builder contextModule(ContextModule contextModule) {
      this.contextModule = Preconditions.checkNotNull(contextModule);
      return this;
    }

    public Builder retrofitModule(RetrofitModule retrofitModule) {
      this.retrofitModule = Preconditions.checkNotNull(retrofitModule);
      return this;
    }

    public Builder okHttpClientModule(OkHttpClientModule okHttpClientModule) {
      this.okHttpClientModule = Preconditions.checkNotNull(okHttpClientModule);
      return this;
    }

    public AppComponent build() {
      Preconditions.checkBuilderRequirement(contextModule, ContextModule.class);
      if (retrofitModule == null) {
        this.retrofitModule = new RetrofitModule();
      }
      if (okHttpClientModule == null) {
        this.okHttpClientModule = new OkHttpClientModule();
      }
      return new DaggerAppComponent(contextModule, retrofitModule, okHttpClientModule);
    }
  }
}