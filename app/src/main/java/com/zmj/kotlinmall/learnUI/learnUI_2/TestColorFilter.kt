package com.zmj.kotlinmall.learnUI.learnUI_2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.kotlinmall.R

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/27
 * Description :
 */
class TestColorFilter: View {
    constructor(context:Context): super(context)
    constructor(context: Context,attributeSet: AttributeSet): super(context,attributeSet)
    constructor(context: Context,attributeSet: AttributeSet,selfSty: Int): super(context,attributeSet,selfSty)

    val paint = Paint()

    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.hencoder)
    val shader = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

    /**
     * 颜色计算方法
     * @param mul  原色相乘的值
     * @param add  原色相加的值
     * R' = R * 0x00 / 0xff + 0x00    //红色被移除
     * G' = G * 0xff / 0xff + 0x00   //绿色保持不变
     * B' = B * 0xff / 0xff + 0x00
     */
    val lightingColorFilter = LightingColorFilter(0x00ffff,0x000000)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.shader = shader
        //paint.colorFilter = lightingColorFilter

        canvas?.drawRect(0f,0f,300f,300f,paint)


        paint.colorFilter = lightingColorFilter

        canvas?.drawRect(520f,0f,820f,300f,paint)
    }

}