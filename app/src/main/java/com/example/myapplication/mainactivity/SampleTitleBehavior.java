package com.example.myapplication.mainactivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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

public class SampleTitleBehavior extends CoordinatorLayout.Behavior<View> {
    // 列表顶部和title底部重合时，列表的滑动距离。
    private float deltaY;

    public SampleTitleBehavior() {
    }

    public SampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof RecyclerView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
        }

        float dy = dependency.getY() - child.getHeight();
        dy = dy < 0 ? 0 : dy;
        float y = -(dy / deltaY) * child.getHeight();
        child.setTranslationY(y);

//        if (deltaY == 0) {
//            deltaY = dependency.getY();
//        }
//        float dy = dependency.getY();
//        dy = dy < 0 ? 0 : dy;
//        float y = -dy / deltaY * child.getHeight();
//        child.setTranslationY(y);

        return true;
    }
}
