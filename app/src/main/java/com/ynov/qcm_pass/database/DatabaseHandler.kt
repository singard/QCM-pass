package com.ynov.qcm_pass.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.ynov.qcm_pass.model.Stat

const val DATABASE_NAME = "StatDB"
const val TABLE_NAME="Stat"
const val COL_ID="id"
const val COL_DATE="date"
const val COL_GOOD_ANSWER_PERCENTAGE="goodAnswerPercentage"

class DatabaseHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_DATE + " VARCHAR(256)," +
                COL_GOOD_ANSWER_PERCENTAGE + " FLOAT)";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(stat: Stat) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_DATE,stat.date)
        cv.put(COL_GOOD_ANSWER_PERCENTAGE,stat.goodAnswerPercentage)

        var result = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong()) {
        }
    }

    @SuppressLint("Range")
    fun readData() : MutableList<Stat> {
        var list: MutableList<Stat> = ArrayList();

        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()) {
            do {
                var stat = Stat()
                stat.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                stat.date = result.getString(result.getColumnIndex(COL_DATE))
                stat.goodAnswerPercentage = result.getString(result.getColumnIndex(
                    COL_GOOD_ANSWER_PERCENTAGE)).toFloat()
                list.add(stat)
                Log.i("DB", stat.date)
            }while (result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }
}