package com.nytimesapp.feature.browse.di.component;

import com.nytimesapp.di.component.AppComponent;
import com.nytimesapp.di.module.multibinding.ViewModelFactoryModule;
import com.nytimesapp.feature.browse.di.modules.MostPopularNewsFactory;
import com.nytimesapp.feature.browse.di.scope.MostPopularNewsScope;
import com.nytimesapp.feature.browse.ui.MostPopularNewsFragment;

import dagger.Component;
@MostPopularNewsScope
@Component(dependencies = AppComponent.class, modules = {MostPopularNewsFactory.class, ViewModelFactoryModule.class})
public interface MostPopularNewsComponent {
    void inject(MostPopularNewsFragment fragment);
}
