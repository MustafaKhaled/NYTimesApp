package com.nytimesapp;

import android.system.Os;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;
import com.nytimesapp.feature.browse.data.repo.MostPopularNewsRepository;
import com.nytimesapp.feature.browse.viewmodel.MostPopularNewsViewModel;
import com.nytimesapp.util.LiveDataTestUtil;
import com.nytimesapp.util.ResponseApi;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.PUT;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
public class ExampleUnitTest {
    @Rule
    public InstantTaskExecutorRule taskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    public MostPopularNewsRepository repository;

    @Mock
    public MostPopularNewsResponse response;

    private MostPopularNewsViewModel viewModel;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        viewModel = new MostPopularNewsViewModel(repository);
    }

    @Test
    public void getNews_non_null() throws InterruptedException {

        Mockito.when(repository.requestMostPopularNews(1)).thenReturn(Single.just(new MostPopularNewsResponse()));
        viewModel.requestMostPopularNews(1);
        assertNotNull(LiveDataTestUtil.getValue(viewModel.getNews()));
    }


}