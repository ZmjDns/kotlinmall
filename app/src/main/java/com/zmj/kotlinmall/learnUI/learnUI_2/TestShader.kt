package com.zmj.kotlinmall.learnUI.learnUI_2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
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

    val linearShader = LinearGradient(100f,100f,500f,500f,Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.shader = linearShader

        canvas?.drawCircle(300f,300f,105f,paint)
    }


}