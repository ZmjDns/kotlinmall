package com.zmj.kotlinmall.dataanalysis

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler
import java.lang.StringBuilder

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/16
 * Description : SAX解析xml
 * x'm'l
 */
class MySaxHandler: DefaultHandler() {

    private var nodeName: String? = null
    private var id = StringBuilder()
    private var name = StringBuilder()
    private var version = StringBuilder()

    override fun startDocument() {
        super.startDocument()
        Log.i("MySaxHandler","Begin parse XML.......")
    }

    override fun startElement(uri: String?, localName: String?, qName: String?, attributes: Attributes?) {
        //记录当前节点名称
        nodeName = localName
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        //根据当前节点名称判断将内容添加到哪一个   StringBuilder中
        if ("id" == nodeName){
            id.append(ch,start,length)
        }else if ("name" == nodeName){
            name.append(ch,start,length)
        }else if ("version" == nodeName){
            version.append(ch,start,length)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        //单个节点结束时，打印出节点数据，清除原来数据
        if ("app" == localName){
            Log.i("MySaxHandler","id is:${id.toString().trim()}")
            Log.i("MySaxHandler","name is:${name.toString().trim()}")
            Log.i("MySaxHandler","version is:${version.toString().trim()}")
            //清空StringBuilder
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }

    override fun endDocument() {
        super.endDocument()
        Log.i("MySaxHandler","SAX Parse over..........")
    }
}