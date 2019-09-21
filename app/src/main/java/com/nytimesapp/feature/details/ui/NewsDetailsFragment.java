package com.nytimesapp.feature.details.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.nytimesapp.R;
import com.nytimesapp.databinding.FragmentNewsDetailsBinding;
import com.nytimesapp.feature.browse.data.model.MediaMetadatum;
import com.nytimesapp.feature.browse.data.model.Result;

import butterknife.ButterKnife;

public class NewsDetailsFragment extends Fragment {
    private Result result;
    private MediaMetadatum media;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        result = NewsDetailsFragmentArgs.fromBundle(getArguments()).getResult();
        media = NewsDetailsFragmentArgs.fromBundle(getArguments()).getMedia();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNewsDetailsBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_details,container,false);
        binding.setResult(result);
        binding.setMedia(media);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

