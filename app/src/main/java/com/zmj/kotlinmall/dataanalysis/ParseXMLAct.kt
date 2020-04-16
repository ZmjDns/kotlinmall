package com.zmj.kotlinmall.dataanalysis

import android.os.Bundle
import android.util.Log
import com.zmj.base.ui.activity.BaseActivity
import com.zmj.kotlinmall.R
import kotlinx.android.synthetic.main.act_parse_xml.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader
import java.net.ContentHandler
import javax.xml.parsers.SAXParserFactory

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/16
 * Description :
 */
class ParseXMLAct: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_parse_xml)

        getData.setOnClickListener {
            getDataFormServer()
        }

    }

    private fun getDataFormServer() {
        MainScope().launch {
            val data = getData()
            tvResult.text = data
            analysisXmlData(data!!)
            analysisXmlBySAX(data)

        }
    }

    suspend fun getData(): String? = withContext(Dispatchers.IO){
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(20,java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(20,java.util.concurrent.TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url("http://192.168.1.254:8080/ACServer/get_data.xml")
            .build()

        val response = okHttpClient.newCall(request).execute()
        return@withContext response.body()?.string()
    }

    suspend fun analysisXmlData(xmlData: String) = withContext(Dispatchers.IO){
        val factory = XmlPullParserFactory.newInstance()
        val xmlPullParser = factory.newPullParser()
        xmlPullParser.setInput(StringReader(xmlData))
        var eventType = xmlPullParser.eventType
        var id = ""
        var name = ""
        var version = ""
        while (eventType != XmlPullParser.END_DOCUMENT){
            val nodeName = xmlPullParser.name
            Log.i("ParseXMLAct","eventType： $eventType   / nodeName: $nodeName")
            when(eventType){
                //开始解析某个点
                XmlPullParser.START_TAG -> {
                   if ("id" == nodeName){
                       id = xmlPullParser.nextText()
                   } else if ("name" == nodeName){
                       name = xmlPullParser.nextText()
                   }else if ("version" == nodeName){
                       version = xmlPullParser.nextText()
                   }
                }
                //完成解析某个点
                XmlPullParser.END_TAG -> {
                    if ("app" == nodeName){
                        Log.i("ParseXMLAct","id is:$id")
                        Log.i("ParseXMLAct","name is:$name")
                        Log.i("ParseXMLAct","version is:$version")
                    }
                }
            }
            eventType = xmlPullParser.next()
        }
    }

    suspend fun analysisXmlBySAX(xmlData: String) = withContext(Dispatchers.IO){
        val factory = SAXParserFactory.newInstance()
        val xmlReader = factory.newSAXParser().xmlReader
        //设置解析器
        xmlReader.contentHandler = MySaxHandler()
        //开始执行解析
        xmlReader.parse(InputSource(StringReader(xmlData)))
    }
}