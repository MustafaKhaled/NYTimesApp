package com.nytimesapp.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.nytimesapp.feature.browse.data.model.Result;

import java.util.List;

public class NewsResultDiffUtil extends DiffUtil.Callback {
    private final List<Result> oldList;
    private final List<Result> newList;

    public NewsResultDiffUtil(List<Result> oldEmployeeList, List<Result> newEmployeeList) {
        this.oldList = oldEmployeeList;
        this.newList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(
                newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Result oldResult = oldList.get(oldItemPosition);
        final Result newResult = newList.get(newItemPosition);

        return oldResult.getTitle().equals(newResult.getTitle());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
