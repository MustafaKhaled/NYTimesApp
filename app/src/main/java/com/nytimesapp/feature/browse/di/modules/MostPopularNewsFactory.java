package com.nytimesapp.feature.browse.di.modules;

import androidx.lifecycle.ViewModel;

import com.nytimesapp.di.module.multibinding.ViewModelKey;
import com.nytimesapp.feature.browse.data.remote.MostPopularNewsApiService;
import com.nytimesapp.feature.browse.di.scope.MostPopularNewsScope;
import com.nytimesapp.feature.browse.viewmodel.MostPopularNewsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
@Module(includes = MostPopularNewsApiServiceModule.class)
public abstract class MostPopularNewsFactory {
    @Binds
    @IntoMap
    @ViewModelKey(MostPopularNewsViewModel.class)
    @MostPopularNewsScope
    abstract ViewModel mostPopular(MostPopularNewsViewModel viewModel);
}
