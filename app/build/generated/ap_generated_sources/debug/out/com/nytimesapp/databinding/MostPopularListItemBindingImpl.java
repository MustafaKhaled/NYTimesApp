package com.nytimesapp.databinding;
import com.nytimesapp.R;
import com.nytimesapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MostPopularListItemBindingImpl extends MostPopularListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 6);
        sViewsWithIds.put(R.id.forward_icon, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MostPopularListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private MostPopularListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.articleImg.setTag(null);
        this.byTextview.setTag(null);
        this.dateTextview.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.newsHeader.setTag(null);
        this.placeTextview.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.result == variableId) {
            setResult((com.nytimesapp.feature.browse.data.model.Result) variable);
        }
        else if (BR.media == variableId) {
            setMedia((com.nytimesapp.feature.browse.data.model.MediaMetadatum) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResult(@Nullable com.nytimesapp.feature.browse.data.model.Result Result) {
        this.mResult = Result;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.result);
        super.requestRebind();
    }
    public void setMedia(@Nullable com.nytimesapp.feature.browse.data.model.MediaMetadatum Media) {
        this.mMedia = Media;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.media);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String resultTitle = null;
        java.lang.String mediaUrl = null;
        java.lang.String resultPublishedDate = null;
        com.nytimesapp.feature.browse.data.model.Result result = mResult;
        com.nytimesapp.feature.browse.data.model.MediaMetadatum media = mMedia;
        java.lang.String resultByline = null;
        java.lang.String resultSection = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (result != null) {
                    // read result.title
                    resultTitle = result.getTitle();
                    // read result.publishedDate
                    resultPublishedDate = result.getPublishedDate();
                    // read result.byline
                    resultByline = result.getByline();
                    // read result.section
                    resultSection = result.getSection();
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (media != null) {
                    // read media.url
                    mediaUrl = media.getUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.nytimesapp.util.ImageUrlBindingAdapter.setImageViewBinding(this.articleImg, mediaUrl);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.byTextview, resultByline);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.dateTextview, resultPublishedDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.newsHeader, resultTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.placeTextview, resultSection);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): result
        flag 1 (0x2L): media
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}