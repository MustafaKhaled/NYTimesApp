// Generated code from Butter Knife. Do not modify!
package com.nytimesapp.feature.browse.ui;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.nytimesapp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MostPopularNewsFragment_ViewBinding implements Unbinder {
  private MostPopularNewsFragment target;

  @UiThread
  public MostPopularNewsFragment_ViewBinding(MostPopularNewsFragment target, View source) {
    this.target = target;

    target.newsRV = Utils.findRequiredViewAsType(source, R.id.news_rv, "field 'newsRV'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MostPopularNewsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.newsRV = null;
  }
}
