package com.nytimesapp.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ImageUrlBindingAdapter {
    @BindingAdapter("android:imgSrc")
    public static void setImageViewBinding(ImageView imageView, String url) {
        if (url != null && !url.equals(""))
            Picasso.get().load(url).fit().into(imageView);

    }
}
