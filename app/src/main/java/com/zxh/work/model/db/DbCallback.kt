package com.zxh.work.model.db


import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper


/**
 * Created by horsttop on 11.October.2018
 */
class DbCallback(version:Int) : SupportSQLiteOpenHelper.Callback(version) {
    override fun onCreate(db: SupportSQLiteDatabase?) {

    }

//    private val CREATE_USER_TABLE = "CREATE TABLE ${UserProfileVo.TABLE} (" +
//            "${UserProfileVo.ID} INTEGER NOT NULL PRIMARY KEY," +
//            "${UserProfileVo.ROLE} INTEGER," +
//            "${UserProfileVo.CODE} TEXT," +
//            "${UserProfileVo.GENDER} INTEGER," +
//            "${UserProfileVo.PHONE} TEXT NOT NULL," +
//            "${UserProfileVo.NICKNAME} TEXT," +
//            "${UserProfileVo.NAME} TEXT," +
//            "${UserProfileVo.AVATAR} TEXT," +
//            "${UserProfileVo.TOKEN} TEXT)"

//    override fun onCreate(db: SupportSQLiteDatabase?) {
//        db?.execSQL(CREATE_USER_TABLE)
//    }

    override fun onUpgrade(db: SupportSQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}