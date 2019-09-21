// Generated by Dagger (https://google.github.io/dagger).
package com.nytimesapp.di.module.context;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ContextModule_ProvidesContextFactory implements Factory<Context> {
  private final ContextModule module;

  public ContextModule_ProvidesContextFactory(ContextModule module) {
    this.module = module;
  }

  @Override
  public Context get() {
    return proxyProvidesContext(module);
  }

  public static ContextModule_ProvidesContextFactory create(ContextModule module) {
    return new ContextModule_ProvidesContextFactory(module);
  }

  public static Context proxyProvidesContext(ContextModule instance) {
    return Preconditions.checkNotNull(
        instance.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
