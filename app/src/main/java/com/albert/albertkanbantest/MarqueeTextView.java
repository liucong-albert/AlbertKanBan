package com.albert.albertkanbantest;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by liuc on 2019-02-25.
 * 主要内容：
 */
public class MarqueeTextView extends android.support.v7.widget.AppCompatTextView implements Runnable{
    public MarqueeTextView(Context context) {
        super(context);
    }

    /** 是否停止滚动 */
    private boolean mStopMarquee;
    private String mText;
    public int mCoordinateX;
    private int mTextWidth;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    /**
     * 开始滚动
     */
    public void Start() {
        mStopMarquee = false;
        mText = this.getText().toString();// 获取文本框文本
        mTextWidth = (int) Math.abs(getPaint().measureText(mText));
        mCoordinateX = mTextWidth;
        post(this);
    }

    @Override
    public void run() {
        if (!mStopMarquee) {
            mCoordinateX += 3;// 滚动速度
            scrollTo(mCoordinateX, 0);
            if (mCoordinateX > mTextWidth) {
                scrollTo(0, 0);
                mCoordinateX = 0;
            }
            postDelayed(this, 50);
        }

    }

    // 继续滚动
    public void Continue() {
        if (mStopMarquee) {
            mStopMarquee = false;
            post(this);
        }
    }

    // 暂停滚动
    public void Paush() {
        mStopMarquee = true;
    }


}