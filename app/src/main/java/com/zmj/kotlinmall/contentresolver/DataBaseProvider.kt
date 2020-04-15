package com.zmj.kotlinmall.contentresolver

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.zmj.kotlinmall.db.MyDataBaseHelper

/**
 * 实现自定义ContentProvider
 */
class DataBaseProvider : ContentProvider() {

    public val BOOK_DIR = 0
    public val BOOK_ITEM = 1
    public val CATEGORY_DIR = 2
    public val CATEGORY_ITEM = 3
    public var AUTHORITY = "com.zmj.kotlinmall.provider"
    private lateinit var dbHelper: MyDataBaseHelper

    private val uriMatcher: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI(AUTHORITY,"book",BOOK_DIR)
        uriMatcher.addURI(AUTHORITY,"book/#",BOOK_ITEM)
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR)
        uriMatcher.addURI(AUTHORITY,"category/#",CATEGORY_ITEM)
    }

    override fun onCreate(): Boolean {
        dbHelper = MyDataBaseHelper(context!!,"BookStore.db",null,1)

        return true
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        val db = dbHelper.readableDatabase
        var cursor: Cursor? = null
        when(uriMatcher.match(uri)){
            BOOK_DIR -> {
                cursor = db.query("Book",projection,selection,selectionArgs,null,null,sortOrder)
            }
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                cursor = db.query("Book",projection,"id = ?", arrayOf(bookId),null,null,sortOrder)
            }
            //Category表一样
        }
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        Log.i("DataBaseProvider","进入方法 ${uri.toString()}")
        val db = dbHelper.writableDatabase
        var uriReturn: Uri? = null
        when(uriMatcher.match(uri)){
            BOOK_DIR -> {
                val newBookId = db.insert("Book",null,values)
                uriReturn = Uri.parse("content://$AUTHORITY/book/$newBookId")
            }
            BOOK_ITEM -> {
                val newBookId = db.insert("Book",null,values)
                uriReturn = Uri.parse("content://$AUTHORITY/book/$newBookId")
            }
        }
        return uriReturn
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        val db = dbHelper.writableDatabase
        var updateRows = 0
        when(uriMatcher.match(uri)){
            BOOK_DIR -> {
                updateRows = db.update("Book",values,selection,selectionArgs)
            }
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                updateRows = db.update("Book",values,"id = ?", arrayOf(bookId))
            }
        }
        return updateRows
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val db = dbHelper.writableDatabase
        var deleteRows = 0
        when(uriMatcher.match(uri)){
            BOOK_DIR -> {
                deleteRows = db.delete("Book",selection,selectionArgs)
            }
            BOOK_ITEM -> {
                val bookId = uri.pathSegments[1]
                deleteRows = db.delete("Book","id = ?", arrayOf(bookId))
            }
        }
        return deleteRows
    }

    override fun getType(uri: Uri): String? {
        when(uriMatcher.match(uri)){
            BOOK_DIR -> {
                return "vnd.android.cursor.dir/vnd.com.zmj.kotlinmall.provider.book"
            }
            BOOK_ITEM -> {
                return "vnd.android.cursor.item/vnd.com.zmj.kotlinmall.provider.book"
            }
            else -> {
                return null
            }
        }
    }
}
