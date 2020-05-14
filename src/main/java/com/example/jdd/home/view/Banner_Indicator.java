package com.example.jdd.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.jdd.R;


/**
 * 轮播图下方指示器
 */
public class Banner_Indicator extends View {

    private Paint paint;
    private Context context;

    private int bannerImageSize;

    int currentItemPosion = 0;

    private int rectf_right_defult = 0;
   private int wind_Width;

    public Banner_Indicator(Context context) {
        this(context,null);
    }

    public Banner_Indicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Banner_Indicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.color_RED));
        getWindWidth();
    }


    public void setBannerImageSize(int bannerImageSize){
        this.bannerImageSize = bannerImageSize;
    }



    public void setCurrentBannerItem(int currentItemPosion){
        this.currentItemPosion = currentItemPosion;
//        因为位置从0开始所以没个加1
        currentItemPosion = currentItemPosion+1;
//        屏幕宽度除以轮播图总数
        rectf_right_defult = wind_Width/bannerImageSize*currentItemPosion;
//        重新绘制
        invalidate();

    }

    public void getWindWidth(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wind_Width = wm.getDefaultDisplay().getWidth();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;

        rectF.right = rectf_right_defult;
        rectF.bottom = 30;

        canvas.drawRect(rectF,paint);
    }


}
