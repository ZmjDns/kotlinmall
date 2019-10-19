package com.zmj.kotlinmall.learnUIPartice

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.act_main_ui_practice.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/10/10
 * Description :
 */
class MainUiPracticeAct: AppCompatActivity() {


    private val pageModels = ArrayList<PageModel>()

    init {
        pageModels.add(PageModel(R.layout.sample_color,R.string.title_draw_color,R.layout.practice_1_color_view))
        pageModels.add(PageModel(R.layout.sample_circel,R.string.title_draw_circle,R.layout.practice_2_circel_view))
        pageModels.add(PageModel(R.layout.sample_rect,R.string.title_draw_rect,R.layout.practice_3_rect_view))
        pageModels.add(PageModel(R.layout.sample_point,R.string.title_draw_point,R.layout.practice_4_point_view))
        pageModels.add(PageModel(R.layout.sample_oval,R.string.title_draw_oval,R.layout.practice_5_oval_view))
        pageModels.add(PageModel(R.layout.sample_line,R.string.title_draw_line,R.layout.practice_6_line_view))
        pageModels.add(PageModel(R.layout.sample_round_rect,R.string.title_draw_round_rect,R.layout.practice_7_round_rect_view))
        pageModels.add(PageModel(R.layout.sample_arc,R.string.title_draw_arc,R.layout.practice_8_arc_view))
        pageModels.add(PageModel(R.layout.sample_path,R.string.title_draw_path,R.layout.practice_9_path_view))
        pageModels.add(PageModel(R.layout.sample_histogram,R.string.title_draw_histogram,R.layout.practice_10_histogram))
        pageModels.add(PageModel(R.layout.sample_pie_chart,R.string.title_draw_pie_chart,R.layout.practice_2_circel_view))

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main_ui_practice)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,pageModels,this)

        tab_layout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }


    override fun onDestroy() {
        super.onDestroy()
    }



    class PageModel{
        @LayoutRes var sampleLayoutRes: Int
        @StringRes var titleRes: Int
        @LayoutRes var practiceLayoutRes: Int

        constructor(@LayoutRes sampleLayoutRes: Int,@StringRes titleRes: Int,@LayoutRes practiceLayoutRes: Int){
            this.sampleLayoutRes = sampleLayoutRes
            this.titleRes = titleRes
            this.practiceLayoutRes = practiceLayoutRes
        }
    }
}