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
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = Color.RED

        canvas?.drawArc(100f,100f,600f,600f,-180f,100f,true,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        paint.strokeWidth = 2f
        path.moveTo(20f,120f)
        path.rLineTo(120f,0f)
        path.lineTo(173.3f,173.3f)

        canvas?.drawPath(path,paint)

        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        //-80度到-45度 扇形
        canvas?.drawArc(110f,100f,610f,600f,-80f,70f,true,paint)

        //画线
        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE
        path.moveTo(518.8f,158.2f)
        path.rLineTo(40f,-40f)
        path.rLineTo(100f,0f)
        canvas?.drawPath(path,paint)
        //继续画-45度到0度 扇形
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        canvas?.drawArc(110f,100f,610f,600f,-45f,35f,true,paint)

        //继续画-10度到0度 扇形
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        canvas?.drawArc(110f,100f,610f,600f,-5f,10f,true,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        paint.strokeWidth = 2f
        path.moveTo(610f,350f)
        path.rLineTo(100f,0f)
        canvas?.drawPath(path,paint)

        paint.color = Color.parseColor("#bbee23")
        paint.style = Paint.Style.FILL

        canvas?.drawArc(110f,100f,610f,600f,10f,50f,true,paint)
        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f

        path.moveTo(570f,490f)
        path.rLineTo(50f,0f)
        path.rLineTo(50f,50f)
        path.rLineTo(100f,0f)

        canvas?.drawPath(path,paint)

        paint.color = Color.parseColor("#007856")
        paint.style = Paint.Style.FILL

        canvas?.drawArc(110f,100f,610f,600f,70f,100f,true,paint)

        paint.color = Color.GRAY
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        path.moveTo(20f,500f)
        path.rLineTo(100f,0f)
        path.rLineTo(25f,-25f)

        canvas?.drawPath(path,paint)
    }

}