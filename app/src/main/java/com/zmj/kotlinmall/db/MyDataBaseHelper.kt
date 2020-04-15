package com.zmj.kotlinmall.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/4/15
 * Description :
 */
class MyDataBaseHelper( var context: Context, dbName: String, cursor: Cursor?, version: Int) :SQLiteOpenHelper(context, dbName, null, version) {

    private val CREATE_BOOK = "create table Book(" +
                            "id integer primary key autoincrement, " +
                            "author text, " +
                            "price real, " +
                            "pages integer, " +
                            "name text)"
    private val CREATE_CATEGORY = "create table Category (" +
                                    "id integer primary key autoincrement, " +
                                    "category_name text, " +
                                    "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_BOOK)
        db?.execSQL(CREATE_CATEGORY)

        Toast.makeText(context,"create tables success",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int){

    }
}