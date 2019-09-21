// Generated by Dagger (https://google.github.io/dagger).
package com.nytimesapp.di.module.NetModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class OkHttpClientModule_ProvidesRetrofitInterceptorFactory
    implements Factory<ApiKeyInterceptor> {
  private final OkHttpClientModule module;

  public OkHttpClientModule_ProvidesRetrofitInterceptorFactory(OkHttpClientModule module) {
    this.module = module;
  }

  @Override
  public ApiKeyInterceptor get() {
    return proxyProvidesRetrofitInterceptor(module);
  }

  public static OkHttpClientModule_ProvidesRetrofitInterceptorFactory create(
      OkHttpClientModule module) {
    return new OkHttpClientModule_ProvidesRetrofitInterceptorFactory(module);
  }

  public static ApiKeyInterceptor proxyProvidesRetrofitInterceptor(OkHttpClientModule instance) {
    return Preconditions.checkNotNull(
        instance.providesRetrofitInterceptor(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
