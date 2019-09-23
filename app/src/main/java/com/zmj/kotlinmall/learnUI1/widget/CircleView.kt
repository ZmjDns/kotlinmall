package com.zmj.kotlinmall.learnUI1.widget

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
 * Time : 2019/9/23
 * Description :
 */
class CircleView: View{

    protected var paint: Paint
    protected var path: Path

    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init {
        paint = Paint()
        path = Path()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.parseColor("#88D81B60")
        paint.strokeWidth = 2.0f
        paint.style = Paint.Style.STROKE //三种   FILL（填充）    STROKE（描边）  FILL_AND_STROKE(填充+ 描边)
        paint.isAntiAlias = true//抗锯齿

        //画圆
        canvas?.drawCircle(300f,300f,200f,paint)

        /*//画五角星
        path.moveTo(200f,0f)
        path.lineTo(318f,362f)
        path.lineTo(10f,138f)
        path.lineTo(390f,138f)
        path.lineTo(82f,362f)
        path.close()
        canvas?.drawPath(path,paint)*/
    }
}

class RectangleView