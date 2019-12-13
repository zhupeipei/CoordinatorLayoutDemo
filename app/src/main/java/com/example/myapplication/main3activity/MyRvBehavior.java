package com.example.myapplication.main3activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRvBehavior extends CoordinatorLayout.Behavior<RecyclerView> {
    public MyRvBehavior() {
    }

    public MyRvBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull RecyclerView child, @NonNull View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull RecyclerView child, @NonNull View dependency) {
        float height = dependency.getHeight() + dependency.getTranslationY();
        child.setY(height);
        return true;
    }
}
