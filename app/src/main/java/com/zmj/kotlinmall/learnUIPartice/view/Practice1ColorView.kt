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
class Practice1ColorView : View{
    constructor(context:Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL

        canvas?.drawColor(Color.YELLOW)
    }

}