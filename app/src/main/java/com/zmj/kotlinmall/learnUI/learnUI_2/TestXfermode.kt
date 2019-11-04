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
 * Time : 2019/10/29
 * Description :
 */
class TestXfermode : View{

    constructor(context: Context): super(context)
    constructor(context: Context, attributeSet: AttributeSet): super(context,attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, selfSty: Int): super(context,attributeSet,selfSty)

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)    //默认抗锯齿

    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.hencoder)
    val circelBitmap = BitmapFactory.decodeResource(resources,R.drawable.chose)

    val xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val save = canvas?.saveLayer(null,null,Canvas.ALL_SAVE_FLAG)
        canvas?.drawBitmap(bitmap,20f,20f,paint)
        paint.setXfermode(xfermode)

        canvas?.drawBitmap(circelBitmap,50f,50f,paint)
        paint.setXfermode(null)

        canvas?.restoreToCount(save!!)

        setLayerType(LAYER_TYPE_HARDWARE,paint)


    }
}