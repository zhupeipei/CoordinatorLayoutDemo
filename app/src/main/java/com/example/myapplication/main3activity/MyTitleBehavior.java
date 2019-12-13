package com.example.myapplication.main3activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class MyTitleBehavior extends CoordinatorLayout.Behavior<View> {
    public MyTitleBehavior() {
    }

    public MyTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        // dependency TextView
        // child title
        int height = child.getHeight();
        float translationY = child.getTranslationY();

        int dependencyHeight = dependency.getHeight();
        float dependencyTranslationY = dependency.getTranslationY();

        float finalTranslationY = -height * (1 + dependencyTranslationY / (dependencyHeight - height));
        if (finalTranslationY < -height) {
            child.setTranslationY(-height);
        } else if (finalTranslationY > 0) {
            child.setTranslationY(0);
        } else {
            child.setTranslationY(finalTranslationY);
        }

        return true;
    }
}
