package com.zmj.uimodel.lesson3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
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

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}