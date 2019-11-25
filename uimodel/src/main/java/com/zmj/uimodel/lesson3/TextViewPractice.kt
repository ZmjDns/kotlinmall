package com.zmj.uimodel.lesson3

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.uimodel.R
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
        paint.style = Paint.Style.STROKE
        paint.color = Color.RED
        paint.strokeWidth = 2f
        //paint.pathEffect = effect

        path.lineTo(150f,300f)
        path.rLineTo(150f,-150f)
        canvas?.drawPath(path,paint);

        //canvas?.drawTextOnPath("HELLO ZMJ",path,0f,0f,paint)
    }

}

class TestText: View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)


    /*val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 2f
//        paint.color = Color.RED


        canvas?.drawText("HELLO ZMJ .",110f,110f,paint)

    }*/

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //paint.setMaskFilter(EmbossMaskFilter())

        canvas?.drawText("HAHHAHAH",20f,100f,paint)
    }

}