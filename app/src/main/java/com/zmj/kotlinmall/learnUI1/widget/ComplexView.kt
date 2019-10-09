package com.zmj.kotlinmall.learnUI1.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.kotlinmall.R
import org.jetbrains.annotations.Nullable

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/27
 * Description :
 */
class PathView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyle: Int): super(context, attrs,defStyle)

    private val paint = Paint()
    private val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL

        //画心
        path.addArc(20f,20f,80f,80f,0f,-180f)
        path.lineTo(80f,160f)
        path.addArc(80f,20f,140f,80f,0f,-180f)
        path.lineTo(80f,160f)

        path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
        path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
        path.lineTo(400f, 542f)

        canvas?.drawPath(path,paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        //画圆
        path.addCircle(800f,150f,100f,Path.Direction.CW)
        path.addCircle(880f,150f,100f,Path.Direction.CCW)
        canvas?.drawPath(path,paint)


        //画线
        path.lineTo(700f,300f)
        //相对位置画线
        path.rLineTo(100f,0f) //相当于 path.lineTo(800f,300f)
        canvas?.drawPath(path,paint)

    }
}

class PathLine:View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyle: Int): super(context, attrs,defStyle)

    private val paint = Paint()
    private val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.STROKE

        //二次贝塞尔曲线
        path.quadTo(100f,100f,200f,200f)
        canvas?.drawPath(path,paint)

        path.rQuadTo(300f,100f,400f,0f)
        canvas?.drawPath(path,paint)

        //三次贝塞尔曲线
        path.moveTo(20f,0f)//修改起始绘制位置
        path.cubicTo(100f,120f,220f,20f,320f,20f)
        canvas?.drawPath(path,paint)


        path.moveTo(10f,0f)
        path.lineTo(100f,110f)
        path.arcTo(100f,100f,300f,300f,-90f,90f,false)
        canvas?.drawPath(path,paint)
    }
}

class CloseView:View {
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyle: Int): super(context, attrs,defStyle)

    private val paint = Paint()
    private val path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE

        path.moveTo(100f, 100f)
        path.lineTo(200f, 100f)
        path.lineTo(150f, 150f)

        //封闭图形
        path.close()

        canvas?.drawPath(path,paint)
    }
}

class BitmapView : View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet):super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val bitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher)

        canvas?.drawBitmap(bitmap,200f,100f,paint)

        canvas?.drawText("Helllo",200f,200f,paint)
    }
}