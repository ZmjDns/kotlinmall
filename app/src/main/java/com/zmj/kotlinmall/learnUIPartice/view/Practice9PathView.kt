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
 * Time : 2019/10/11
 * Description :
 */
class Practice9PathView: View {

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()
    val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK

        paint.style = Paint.Style.FILL
        paint.strokeWidth = 2f

        //path.moveTo(50f,100f)
        path.addArc(0f,0f,100f,100f,-225f,225f)
        path.addArc(100f,0f,200f,100f,-180f,225f)
        path.lineTo(100f,200f)
        path.lineTo(14.65f,85.35f)
        //path.close()

        canvas?.drawPath(path,paint)


    }
}