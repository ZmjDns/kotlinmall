package com.zmj.kotlinmall.learnUI.learnUI_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/11/14
 * Description :
 */
class TestShadowLayer: View {
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint();

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        setLayerType(View.LAYER_TYPE_HARDWARE,null)
        setLayerType(LAYER_TYPE_SOFTWARE,null)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f

        paint.setShadowLayer(10f,0f,0f,Color.RED);

        canvas?.drawText("Hello ZMJ",10f,10f,paint)


    }


}