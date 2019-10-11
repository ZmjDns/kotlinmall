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
class Practice7RoundRectView : View {

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL

        canvas?.drawRoundRect(50f,50f,300f,260f,20f,20f,paint)
    }
}