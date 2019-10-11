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
 * Time : 2019/10/10
 * Description :
 */
class Practice3RectView : View{

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawRect() 方法画矩形
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK

        canvas?.drawRect(20f,20f,400f,400f,paint)
    }
}