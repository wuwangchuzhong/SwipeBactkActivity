package com.yidian.buyer.activity.synchronousauction.live;

/**
 * Created by miao on 2017/7/3.
 * /**
 * 想要实现向右滑动删除Activity效果只需要继承SwipeBackActivity即可，如果当前页面含有ViewPager
 * 只需要调用SwipeBackLayout的setViewPager()方法即可
 *
 * @author xiaanming
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.yidian.buyer.R;
import com.yidian.buyer.utils.UiUtils;
import com.yidian.buyer.view.SwipeBackLayout;
public class SwipeBackActivity extends  Activity {

    protected SwipeBackLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏透明
        UiUtils.setWindow(this);
        layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                R.layout.base, null);
        layout.attachToActivity(this);
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    // Press the back button in mobile phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(0, R.anim.base_slide_right_out);
    }
}
