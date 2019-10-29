package com.zmj.kotlinmall.learnUI.learnUI_2

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
 * Time : 2019/10/23
 * Description :
 * paint中着色的另一种方案 第一种就是paint.color / paint.rgb
 */
class TestShader : View{

    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()


    //线性渐变颜色
    //CLAMP
    val linearShaderClamp = LinearGradient(100f,100f,500f,500f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
    //MIRROR
    val linearShaderMirror = LinearGradient(500f,100f,800f,400f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.MIRROR)
    //REPEAT
    val linearShaderRepeat = LinearGradient(50f,500f,350f,800f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.REPEAT)

    //辐射渐变颜色
    val radialShaderClamp = RadialGradient(500f,500f,150f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.isAntiAlias = true
        paint.shader = linearShaderClamp

        canvas?.drawCircle(250f,250f,200f,paint)

        paint.shader = linearShaderMirror
        canvas?.drawRect(500f,100f,800f,400f,paint)

        paint.shader = linearShaderRepeat
        canvas?.drawRect(50f,500f,350f,800f,paint)

        paint.shader = radialShaderClamp
        canvas?.drawCircle(500f,500f,150f,paint)

    }
}

class TestRadioGradientShader: View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    //辐射渐变颜色
    /**
     * @param (centerX,centerY)是绝对坐标（相对于屏幕的原点），
     */
    val radialGradientShaderClamp = RadialGradient(300f,300f,200f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
    //MIRROR
    val radioGradientShaderMirror = RadialGradient(800f,300f,100f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.MIRROR)
    //REPEAT
    val radioGradientShaderRepeat = RadialGradient(300f,700f,100f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.REPEAT)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = radialGradientShaderClamp
        canvas?.drawCircle(300f,300f,200f,paint)

        paint.shader = radioGradientShaderMirror
        canvas?.drawCircle(800f,300f,200f,paint)

        paint.shader = radioGradientShaderRepeat
        canvas?.drawCircle(300f,700f,300f,paint)
    }
}

class TestSweepGradient: View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    //扫描渐变颜色
    val sweepGradientShader = SweepGradient(200f,200f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"))

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = sweepGradientShader
        canvas?.drawCircle(200f,200f,200f,paint)
    }
}

class TestBitmapShader: View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    //CLAMP
    val bitmapShader = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
    //MIRROR
    val bitmapShaderMirror = BitmapShader(bitmap,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)
    //REPEAT
    val bitmapShaderRepeat = BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = bitmapShader


        //canvas?.drawBitmap(bitmap,20f,20f,paint)
        canvas?.drawCircle(85f,84f,80f,paint)

        paint.shader = bitmapShaderMirror
        canvas?.drawRect(0f,200f,500f,700f,paint)

        paint.shader = bitmapShaderRepeat
        canvas?.drawRect(520f,200f,1020f,700f,paint)
    }
}

class TestComposerShader: View{
    constructor(context: Context): super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, @Nullable attrs: AttributeSet, @Nullable defStyle: Int): super(context, attrs,defStyle)

    val paint = Paint()

    //第一个shader ： batman头像
    val bitmapBatman = BitmapFactory.decodeResource(resources,R.drawable.batman)
    val shaderBatman = BitmapShader(bitmapBatman,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

    //第二个shader： 从上倒下的渐变（由透明到黑色）
    val bitmapLoglo = BitmapFactory.decodeResource(resources,R.drawable.chose)
    val shaderLogo = BitmapShader(bitmapLoglo,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

    //结合两个Shader
    //val composerShader = ComposeShader(shaderBatman,shaderLogo,PorterDuff.Mode.SRC_OVER)

    //挖空效果
    val composerShader1 = ComposeShader(shaderBatman,shaderLogo,PorterDuff.Mode.DST_OUT)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = composerShader1

        canvas?.drawCircle(85f,84f,80f,paint)
    }
}