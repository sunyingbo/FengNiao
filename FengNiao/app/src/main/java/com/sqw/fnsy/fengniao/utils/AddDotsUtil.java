package com.sqw.fnsy.fengniao.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sqw.fnsy.fengniao.R;

/**
 * Created by SUN on 2016/9/23.
 */
public class AddDotsUtil {

    /**
     * 在轮播图片底部动态添加圆点
     * @param context 上下文对象
     * @param linearLayout 线性布局对象
     * @param size 图片数量，根据图片数量添加相应的圆点
     */
    public static void addDot(Context context, LinearLayout linearLayout, int size) {
        for (int i = 0; i < size; i++) {
            ImageView dotImg = new ImageView(context);
            dotImg.setImageResource(R.mipmap.point_default);
            int width = dip2px(context, 6);
            int height = dip2px(context, 6);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            int left = dip2px(context, 2);
            int top = dip2px(context, 2);
            int right = dip2px(context, 2);
            int bottom = dip2px(context, 2);
            params.setMargins(left, top, right, bottom);
            dotImg.setLayoutParams(params);
            linearLayout.addView(dotImg);
        }
        // 默认设置第一个圆点为选中状态
        linearLayout.getChildAt(0).setSelected(true);
        // 默认设置第一个圆点为选中时的图片
        ((ImageView)linearLayout.getChildAt(0)).setImageResource(R.mipmap.point_focus);
    }

    /**
     * 设备像素(dip,dp)转屏幕像素(px)
     * px就是像素，如果用px,就会用实际像素画，比个如吧，用画一条长度为240px的横线，在480宽的模拟器上看就是一半的屏宽，而在320宽的模拟器上看就是2／3的屏宽了。
     　　  * 而dip，就是把屏幕的高分成480分，宽分成320分。比如你做一条160dip的横线，无论你在320还480的模拟器上，都是一半屏的长度。
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param pxValue
     *      （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param spValue
     *      （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}