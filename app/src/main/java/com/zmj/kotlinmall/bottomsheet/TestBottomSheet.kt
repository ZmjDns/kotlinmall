package com.zmj.kotlinmall.bottomsheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.activity_test_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/9/26
 * Description :
 */
class TestBottomSheet: AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_test_bottom_sheet)

        initBottom()
        //initBottomSheetDialog()

        btn_show.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_HIDDEN){
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            }else{
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }
    }

    fun initBottom(){
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        /*bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)*/
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)

        bottomSheetBehavior.setBottomSheetCallback(object:BottomSheetBehavior.BottomSheetCallback(){

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.i("onStateChanged:","newState: $newState")
            }

            override fun onSlide(bottomSheet: View, slideOffSide: Float) {
                Log.i("onSlide:","newState: $slideOffSide")
            }
        })
    }

    fun initBottomSheetDialog(){
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet)



        /*bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)*/

    }


}