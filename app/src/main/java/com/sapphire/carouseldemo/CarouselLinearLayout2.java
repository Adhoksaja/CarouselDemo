package com.sapphire.carouseldemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Sapphire on 13/05/17.
 */

public class CarouselLinearLayout2 extends LinearLayout {
    private float scale = CarouselPagerAdapter2.BIG_SCALE;

    public CarouselLinearLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarouselLinearLayout2(Context context) {
        super(context);
    }

    public void setScaleBoth(float scale) {
        this.scale = scale;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // The main mechanism to display scale animation, you can customize it as your needs
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale, scale, w/2, h/2);
    }
}
