package com.nytimesapp.feature.browse.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nytimesapp.R;
import com.nytimesapp.di.module.multibinding.DaggerViewModelFactory;
import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;
import com.nytimesapp.feature.browse.data.model.Result;
import com.nytimesapp.feature.browse.di.component.DaggerMostPopularNewsComponent;
import com.nytimesapp.feature.browse.ui.adapter.MostPopularNewsAdapter;
import com.nytimesapp.feature.browse.viewmodel.MostPopularNewsViewModel;
import com.nytimesapp.util.MyApp;
import com.nytimesapp.util.ResponseApi;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import timber.log.Timber;

public class MostPopularNewsFragment extends Fragment {
    @Inject
    DaggerViewModelFactory factory;
    @BindView(R.id.news_rv)
    RecyclerView newsRV;
    private MostPopularNewsAdapter adapter = new MostPopularNewsAdapter();
    private MostPopularNewsViewModel viewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMostPopularNewsComponent.builder()
                .appComponent(((MyApp)getActivity().getApplication()).getAppComponent())
                .build()
                .inject(this);
        viewModel = ViewModelProviders.of(this,factory).get(MostPopularNewsViewModel.class);
        viewModel.requestMostPopularNews(1);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_popular,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        observeNew();

    }

    private void setUpRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        newsRV.setHasFixedSize(true);
        newsRV.setLayoutManager(layoutManager);
        newsRV.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        newsRV.setAdapter(adapter);
    }

    private void observeNew(){
        viewModel.getNews().observe(this,newsObserver);
    }

   final private Observer<ResponseApi<MostPopularNewsResponse>> newsObserver = response -> {
        switch (response.status){
            case LOADING:
                Timber.d("Loading");
                break;

            case SUCCESS:
                List<Result> results = response.data.getResults();
                adapter.addItems(results);
                break;

            case ERROR:
                Timber.d("Error");
                break;
        }
    };

}
