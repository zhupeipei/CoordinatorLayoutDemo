package com.example.myapplication.main3activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//onInterceptTouchEvent()：是否拦截触摸事件
//onTouchEvent()：处理触摸事件
//layoutDependsOn()：确定使用Behavior的View要依赖的View的类型
//onDependentViewChanged()：当被依赖的View状态改变时回调
//onDependentViewRemoved()：当被依赖的View移除时回调
//onMeasureChild()：测量使用Behavior的View尺寸
//onLayoutChild()：确定使用Behavior的View位置
//onStartNestedScroll()：嵌套滑动开始（ACTION_DOWN），确定Behavior是否要监听此次事件
//onStopNestedScroll()：嵌套滑动结束（ACTION_UP或ACTION_CANCEL）
//onNestedScroll()：嵌套滑动进行中，要监听的子 View的滑动事件已经被消费
//onNestedPreScroll()：嵌套滑动进行中，要监听的子 View将要滑动，滑动事件即将被消费（但最终被谁消费，可以通过代码控制）
//onNestedFling()：要监听的子 View在快速滑动中
//onNestedPreFling()：要监听的子View即将快速滑动

public class MyHeaderBehavior extends CoordinatorLayout.Behavior<TextView> {
    private boolean mIsOnTop = false;
    private boolean mIsOnBottom = true;

    public MyHeaderBehavior() {
    }

    public MyHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    // dy > 0 表示向上滑动
    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);

        if (target instanceof RecyclerView) {
            float translationY = child.getTranslationY();
            float finalTranslationY = translationY - dy;
            float height = child.getHeight();
            int pos = ((LinearLayoutManager) ((RecyclerView) target).getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();

            if (pos == 0) {
                float finalCanTranslationY;
                if (finalTranslationY <= -height) {
                    finalCanTranslationY = -height;
                } else if (finalTranslationY >= 0) {
                    finalCanTranslationY = 0;
                } else {
                    finalCanTranslationY = finalTranslationY;
                }
                float canDy = translationY - finalCanTranslationY;
                child.setTranslationY(finalCanTranslationY);
                consumed[1] = (int) canDy;
            }

//            if (dy > 0) {
//                mIsOnBottom = false;
//                if (mIsOnTop) {
//                    return;
//                } else {
//                    if (finalTranslationY < -height) {
//                        mIsOnTop = true;
//                        child.setTranslationY(-height);
//                        consumed[1] = (int) (height + translationY);
//                    } else {
//                        child.setTranslationY(finalTranslationY);
//                        consumed[1] = dy;
//                    }
//                }
//            } else {
//                mIsOnTop = false;
//                if (pos != 0) {
//                    return;
//                } else if (mIsOnBottom) {
//                    return;
//                } else {
//                    if (finalTranslationY >= 0) {
//                        mIsOnBottom = true;
//                        child.setTranslationY(0);
//                        consumed[1] = (int) (translationY);
//                    } else {
//                        child.setTranslationY(finalTranslationY);
//                        consumed[1] = dy;
//                    }
//                }
//            }
        }
    }

}
