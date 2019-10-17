package com.zmj.kotlinmall.learnUIPartice.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/14
 * Description :
 */
class Practice10HistogramView : View{

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()
    val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.GREEN
        paint.strokeWidth = 40f

        path.moveTo(50f,50f)
        path.addRect(50f,50f,90f,300f,Path.Direction.CW)

        path.moveTo(120f,20f)
        path.addRect(120f,20f,160f,300f,Path.Direction.CW)

        canvas?.drawPath(path,paint)

    }

}