package com.zmj.kotlinmall.learnUI.widget

import android.content.Context
import android.graphics.*
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

class RectangleView: View{
    private val paint: Paint

    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context,attrs,defStyleAttr)

    init {
        paint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //画矩形
        //paint.style = Paint.Style.FILL
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        paint.strokeWidth = 2f
        canvas?.drawRect(0f,0f,200f,200f,paint)


        paint.style = Paint.Style.FILL_AND_STROKE
        val rect = Rect(250,0,450,200)
        canvas?.drawRect(rect,paint)
    }
}

class PointView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context,attrs, defStyleAttr)

    private val paint: Paint
    init {
        paint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.RED
        //画圆
        paint.strokeWidth = 20f
        paint.strokeCap = Paint.Cap.BUTT
        canvas?.drawPoint(50f,30f,paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(100f,30f,paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawPoint(150f,30f,paint)

        //批量绘点
        val points = floatArrayOf(20f,70f,70f,70f,120f,70f,170f,70f,220f,70f,290f,70f)
        canvas?.drawPoints(points,paint)

    }
}

class OvalView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context,attrs,defStyleAttr)

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.CYAN
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        //画椭圆
        canvas?.drawOval(0f,0f,200f,160f,paint)

        paint.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawOval(220f,0f,420f,160f,paint)

        canvas?.drawOval(RectF(0f,220f,220f,420f),paint)

    }
}

class LineView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context,attrs, defStyleAttr)

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.strokeWidth = 20f
        //画一条线
        canvas?.drawLine(20f,20f,120f,120f,paint)

        //画多条线
        val points = floatArrayOf(200f,20f,200f,200f,150f,200f,300f,200f,200f,100f,280f,100f)
        canvas?.drawLines(points,paint)

    }
}

class RoundRect: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context,attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.BLACK
        paint.strokeWidth = 20f
        paint.style = Paint.Style.FILL
        //画实心圆角矩形
        canvas?.drawRoundRect(20f,20f,100f,100f,20f,20f,paint)

        //空心矩形
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        canvas?.drawRoundRect(120f,20f,220f,100f,20f,20f,paint)
    }
}

class ArcView: View{
    constructor(context: Context): super(context)
    constructor(context: Context,@Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context,@Nullable attrs: AttributeSet,@Nullable defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private  val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val rect = RectF(20f,20f,260f,200f)

        paint.style = Paint.Style.STROKE

        //弧线
        /**
         * @param rect 椭圆
         * @param startAngle 起始角度，x轴为正方向，
         * @param sweepAngle 扫过的角度，顺时针为正方向
         * @param useCenter 是否连线到圆心
         */
        canvas?.drawArc(rect,-110f,-100f,false,paint)
        //空心扇形
        paint.strokeWidth = 2f
        canvas?.drawArc(rect,0f,-100f,true,paint)
        //实心扇形
        paint.style = Paint.Style.FILL
        canvas?.drawArc(rect,10f,160f,true,paint)

    }
}
























