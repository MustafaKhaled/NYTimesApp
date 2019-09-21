package com.nytimesapp.feature.browse.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;
import com.nytimesapp.feature.browse.data.repo.MostPopularNewsRepository;
import com.nytimesapp.util.ResponseApi;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MostPopularNewsViewModel extends ViewModel {
    private MostPopularNewsRepository repository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<ResponseApi<MostPopularNewsResponse>> newsResponseLiveData = new MutableLiveData<>();
    @Inject
    public MostPopularNewsViewModel(MostPopularNewsRepository repository) {
        this.repository = repository;
    }

    public void requestMostPopularNews(int period) {
        disposable.add(repository.requestMostPopularNews(period)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(loading -> newsResponseLiveData.setValue(ResponseApi.loading()))
                .subscribe(result -> newsResponseLiveData.setValue(ResponseApi.success(result)),
                        throwable -> newsResponseLiveData.setValue(ResponseApi.error(throwable))
                ));

    }

    public LiveData<ResponseApi<MostPopularNewsResponse>> getNews(){
        return newsResponseLiveData;

    }

}
