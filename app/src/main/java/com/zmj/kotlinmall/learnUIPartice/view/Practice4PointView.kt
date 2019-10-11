package com.zmj.kotlinmall.learnUIPartice.view

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
 * Time : 2019/10/11
 * Description :
 */
class Practice4PointView : View {

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f

        paint.strokeCap = Paint.Cap.BUTT
        canvas?.drawPoint(50f,50f,paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(100f,50f,paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawPoint(150f,50f,paint)

    }
}