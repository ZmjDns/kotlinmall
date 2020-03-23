package com.zmj.kotlinmall.common;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/3/23
 * Description :
 */
public class DensityUtil {
    private static float appDensity;
    private static float appScaledDensity;
    private static DisplayMetrics appDisplayMetrics;
    private static int barHeight;

    public static void setAppDensity(@NonNull final Application application){
        //
        appDisplayMetrics = application.getResources().getDisplayMetrics();

        //获取状态栏的高度，用于适配屏幕高度时去掉状态栏高度
        barHeight = getBarHeight(application);

        if (appDensity == 0){
            appDensity = appDisplayMetrics.density;
            appScaledDensity = appDisplayMetrics.scaledDensity;

            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    //字体改变后要重新给 appScaledDensity赋值
                    if (newConfig != null && appScaledDensity > 0){
                        appScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }
                @Override
                public void onLowMemory() {}
            });
        }
    }

    /**
     * 此方法用于在BaseActivity中做统一的适配设置，
     * 如果没有BaseActivity可以直接在Activity中调用下一个方法
     * @param activity
     */
    public static void setDefaultDensity(Activity activity){
        //默认设置横屏适配
        setAppOrientation(activity,"width");
    }

    //此方法用于在activity中设置适配的方向
    public static void setCompatOrientation(Activity activity,String orientation){
        setAppOrientation(activity,orientation);
    }


    /**
     * targetDensity
     * targetScaledDensity
     * targetDensityDpi
     * 为统一修改过的值，用于适配
     * @param activity
     * @param orientation 传入的需要适配的方向width/height
     */
    private static void setAppOrientation(@Nullable Activity activity,String orientation){
        float targetDensity;
        if (orientation.equals("height")){
            //纵向基于667dp进行适配
            targetDensity = (appDisplayMetrics.heightPixels - barHeight) / 667f;
        }else {
            //横向基于360dp进行适配
            targetDensity = appDisplayMetrics.widthPixels / 360f;
        }

        float targetScaledDensity = targetDensity * (appScaledDensity / appDensity);
        int targetDensityDpi = (int) targetScaledDensity * 160;

        DisplayMetrics actDM = activity.getResources().getDisplayMetrics();
        actDM.density = targetDensity;
        actDM.densityDpi = targetDensityDpi;
        actDM.scaledDensity = targetScaledDensity;
    }

    //获取status_bar高度
    private static int getBarHeight(Application application){
        int result = 0;
        int resourceId = application.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0){
            result = application.getResources().getDimensionPixelSize(resourceId);
        }
        if (result > 0) return resourceId;

        //上面获取不到就用反射
        Class c = null;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            Object object = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(object).toString());
            result = application.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
