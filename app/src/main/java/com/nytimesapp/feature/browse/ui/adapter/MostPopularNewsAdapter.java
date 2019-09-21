package com.nytimesapp.feature.browse.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nytimesapp.R;
import com.nytimesapp.databinding.MostPopularListItemBinding;
import com.nytimesapp.feature.browse.data.model.Result;

import java.util.ArrayList;
import java.util.List;

public class MostPopularNewsAdapter extends RecyclerView.Adapter<MostPopularNewsAdapter.NewsViewHolder> {

    private List<Result> results = new ArrayList<>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MostPopularListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.most_popular_list_item, parent, false);
        return new NewsViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void addItems(List<Result> newResults) {
        results.addAll(newResults);
        notifyItemRangeInserted(results.size() - 1, newResults.size()-1);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private MostPopularListItemBinding binding;

        public NewsViewHolder(@NonNull View itemView, MostPopularListItemBinding binding) {
            super(itemView);
            this.binding = binding;
        }

        public void bind(Result result) {
            binding.setResult(result);
            binding.setMedia(result.getMedia().get(0).getMediaMetadata().get(0));
            binding.executePendingBindings();

        }
    }
}
