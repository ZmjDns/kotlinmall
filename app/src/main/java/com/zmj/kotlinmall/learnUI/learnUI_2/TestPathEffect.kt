package com.zmj.kotlinmall.learnUI.learnUI_2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/11/5
 * Description :
 */
class TestPathEffect: View {
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()
    val path = Path()
    var pathEffect = CornerPathEffect(20f);

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f;

        path.moveTo(10f,10f)
        path.rLineTo(50f,50f)
        path.rLineTo(40f,3f)

        paint.pathEffect = pathEffect
        canvas?.drawPath(path,paint)
    }
}