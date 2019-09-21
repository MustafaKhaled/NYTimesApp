// Generated by Dagger (https://google.github.io/dagger).
package com.nytimesapp.di.module.NetModule;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RetrofitModule_ProvidesGsonFactory implements Factory<Gson> {
  private final RetrofitModule module;

  public RetrofitModule_ProvidesGsonFactory(RetrofitModule module) {
    this.module = module;
  }

  @Override
  public Gson get() {
    return proxyProvidesGson(module);
  }

  public static RetrofitModule_ProvidesGsonFactory create(RetrofitModule module) {
    return new RetrofitModule_ProvidesGsonFactory(module);
  }

  public static Gson proxyProvidesGson(RetrofitModule instance) {
    return Preconditions.checkNotNull(
        instance.providesGson(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
