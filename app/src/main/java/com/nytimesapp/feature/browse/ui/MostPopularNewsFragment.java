package com.nytimesapp.feature.browse.ui;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.nytimesapp.R;
import com.nytimesapp.di.module.multibinding.DaggerViewModelFactory;
import com.nytimesapp.feature.browse.data.model.MostPopularNewsResponse;
import com.nytimesapp.feature.browse.data.model.Result;
import com.nytimesapp.feature.browse.di.component.DaggerMostPopularNewsComponent;
import com.nytimesapp.feature.browse.ui.adapter.MostPopularNewsAdapter;
import com.nytimesapp.feature.browse.ui.adapter.OnItemSelected;
import com.nytimesapp.feature.browse.viewmodel.MostPopularNewsViewModel;
import com.nytimesapp.feature.details.ui.NewsDetailsFragment;
import com.nytimesapp.util.MyApp;
import com.nytimesapp.util.ResponseApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import timber.log.Timber;

public class MostPopularNewsFragment extends Fragment implements OnItemSelected {
    @Inject
    DaggerViewModelFactory factory;
    @BindView(R.id.news_rv)
    RecyclerView newsRV;
    @BindView(R.id.progress_bar)
    ProgressBar newsProgressBar;
    private MostPopularNewsAdapter adapter = new MostPopularNewsAdapter(this);
    private MostPopularNewsViewModel viewModel;
    private List<Result> results;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMostPopularNewsComponent.builder()
                .appComponent(((MyApp) getActivity().getApplication()).getAppComponent())
                .build()
                .inject(this);
        viewModel = ViewModelProviders.of(this, factory).get(MostPopularNewsViewModel.class);
        viewModel.requestMostPopularNews(1);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_most_popular, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
        observeNew();
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                query = query.toLowerCase();
                ArrayList<Result> newList = new ArrayList<>();
                for (Result result: results){
                    String channelName = result.getTitle().toLowerCase();
                    if (channelName.contains(query)){
                        newList.add(result);
                    }
                }
                adapter.setFilter(newList);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.last_day:
                    viewModel.requestMostPopularNews(1);
                break;

            case R.id.last_7_days:
                viewModel.requestMostPopularNews(7);

                break;

            case R.id.last_30_days:
                viewModel.requestMostPopularNews(30);

                break;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        newsRV.setHasFixedSize(true);
        newsRV.setLayoutManager(layoutManager);
        newsRV.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        newsRV.setAdapter(adapter);
    }

    private void observeNew() {
        viewModel.getNews().observe(this, newsObserver);
    }

    final private Observer<ResponseApi<MostPopularNewsResponse>> newsObserver = response -> {
        switch (response.status) {
            case LOADING:
                Timber.d("Loading");
                newsProgressBar.setVisibility(View.VISIBLE);
                return;

            case SUCCESS:
                results = response.data.getResults();
                adapter.addItems(results);

                break;

            case ERROR:
                Timber.d("Error");

                break;
        }
        newsProgressBar.setVisibility(View.GONE);
    };

    @Override
    public void onClicked(Result result) {
        Navigation.findNavController(getView()).navigate(navigateToDetails(result));
    }

    private MostPopularNewsFragmentDirections.ActionMostPopularNewsFragmentToNewsDetailsFragment navigateToDetails(Result result){
        return MostPopularNewsFragmentDirections.actionMostPopularNewsFragmentToNewsDetailsFragment(result,result.getMedia().get(0).getMediaMetadata().get(0));
    }
}
