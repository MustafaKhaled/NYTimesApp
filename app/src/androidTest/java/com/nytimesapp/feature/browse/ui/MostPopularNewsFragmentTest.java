package com.nytimesapp.feature.browse.ui;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.nytimesapp.MainActivity;
import com.nytimesapp.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;

public class MostPopularNewsFragmentTest {
    @Rule
    public ActivityTestRule<MainActivity> intentsTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void scroll_down_and_click(){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(ViewMatchers.withId(R.id.news_rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition(13, ViewActions.click()));
    }
}