package com.example.mycryptoapp.data.database.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mycryptoapp.models.Transaction
import com.example.mycryptoapp.util.Constants.Companion.DATABASE_NAME_SQLITE
import com.example.mycryptoapp.util.Constants.Companion.DATABASE_VERSION_SQLITE
import com.example.mycryptoapp.util.Constants.Companion.TBL_TRANSACTIONS_HISTORY


class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME_SQLITE, null, DATABASE_VERSION_SQLITE) {

    companion object {
        private const val TITLE = "title"
        private const val SYMBOL = "symbol"
        private const val DESCRIPTION = "description"
        private const val DATETIME = "datetime"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblTransactionsHistory = ("CREATE TABLE" + TBL_TRANSACTIONS_HISTORY + "("
                + TITLE + "TEXT," + SYMBOL + "TEXT,"
                + DESCRIPTION + "TEXT," + DATETIME + "INTEGER PRIMARY KEY" + ")")
        db?.execSQL(createTblTransactionsHistory)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_TRANSACTIONS_HISTORY")
        onCreate(db)
    }

    fun insertTransaction(transaction: Transaction): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(TITLE, transaction.title)
        contentValues.put(SYMBOL, transaction.symbol)
        contentValues.put(DESCRIPTION, transaction.description)
        contentValues.put(DATETIME, System.currentTimeMillis())

        val success = db.insert(TBL_TRANSACTIONS_HISTORY, null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllTransaction(): ArrayList<Transaction> {
        val transactionList: ArrayList<Transaction> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_TRANSACTIONS_HISTORY"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var title: String
        var description: String
        var symbol: String
        var dateTime: Int

        if (cursor.moveToFirst()) {

            do {
                title = cursor.getString(cursor.getColumnIndex(TITLE))
                description = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
                symbol = cursor.getString(cursor.getColumnIndex(SYMBOL))
                dateTime = cursor.getInt(cursor.getColumnIndex(DATETIME))
                val transaction = Transaction(
                    title = title,
                    description = description,
                    symbol = symbol,
                    dateTime = dateTime
                )
                transactionList.add(transaction)
            } while (cursor.moveToNext())

        }
        return transactionList
    }

}