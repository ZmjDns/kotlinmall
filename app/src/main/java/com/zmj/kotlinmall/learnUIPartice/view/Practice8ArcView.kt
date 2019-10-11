package com.zmj.kotlinmall.learnUIPartice.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
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
class Practice8ArcView : View {

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f

        canvas?.drawArc(RectF(50f,50f,300f,260f),-100f,-100f,false,paint)

        paint.style = Paint.Style.FILL
        canvas?.drawArc(RectF(60f,60f,310f,270f),-10f,-95f,true,paint)

        canvas?.drawArc(RectF(50f,130f,320f,320f),0f,180f,true,paint)

    }
}