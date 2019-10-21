package com.zmj.kotlinmall.learnUIPartice.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.PathInterpolator
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/17
 * Description : 饼状图
 */
class Practice11PieChart: View {

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()
    val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        canvas?.drawArc(100f,100f,600f,600f,-180f,100f,true,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        paint.strokeWidth = 2f
        path.moveTo(80f,150f)
        path.rLineTo(80f,0f)
        path.lineTo(173.3f,173.3f)

        canvas?.drawPath(path,paint)

        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        canvas?.drawArc(110f,100f,610f,600f,0f,-80f,true,paint)

        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE
        path.moveTo(426.7f,173.3f)
        path.lineTo(610f,100f)
        path.rLineTo(100f,0f)

        canvas?.drawPath(path,paint)

    }

}