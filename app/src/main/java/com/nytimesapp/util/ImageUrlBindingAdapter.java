package com.nytimesapp.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.nytimesapp.R;
import com.squareup.picasso.Picasso;

public class ImageUrlBindingAdapter {
    @BindingAdapter("android:imgSrc")
    public static void setImageViewBinding(ImageView imageView, String url) {
        if (url != null && !url.equals(""))
            Picasso.get().load(url).fit().into(imageView);
        else
            Picasso.get().load(R.drawable.ic_library_books_black_24dp).into(imageView);

    }
}
