package com.zmj.uimodel.lesson3

import android.content.Context
import android.graphics.Canvas
import android.graphics.CornerPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.media.effect.Effect
import android.util.AttributeSet
import android.view.View
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/11/20
 * Description :
 */
class TextViewPractice: View {
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyle: Int): super(context, attrs,defStyle)

    val path = Path()
    val paint = Paint()
    val effect = CornerPathEffect(5f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.pathEffect = effect

        path.rLineTo(150f,300f)
        path.rLineTo(150f,-150f)
        canvas?.drawPath(path,paint);

        canvas?.drawTextOnPath("HELLO ZMJ",path,0f,0f,paint)
    }

}