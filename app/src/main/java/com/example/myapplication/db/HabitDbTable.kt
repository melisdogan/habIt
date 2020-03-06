package com.example.myapplication.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.SyncStateContract.Helpers.insert
import com.example.myapplication.Habit

class HabitDbTable(context: Context){

    private val dbHelper = HabitDb(context)

    fun readAllHabits():List<Habit>{
        val columns = arrayOf(HabitEntry._ID, HabitEntry.TITLE_COL, HabitEntry.DESC_COL)
        val db = dbHelper.readableDatabase
        val cursor = db.query(HabitEntry.TABLE_NAME, columns, null,null,null,null,"${HabitEntry._ID} ASC")
        val habits = mutableListOf<Habit>()
        while(cursor.moveToNext()){
            habits.add(Habit(cursor.getThatString(HabitEntry.TITLE_COL),cursor.getThatString(HabitEntry.DESC_COL)))
        }
        cursor.close()
        return habits
    }
    private fun Cursor.getThatString(columnName: String) = getString(getColumnIndex(columnName))


    //fun

    fun store (habit: Habit): Long {
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(HabitEntry.TITLE_COL, habit.title)
        values.put(HabitEntry.DESC_COL, habit.description)



        return db.transaction {
            insert(HabitEntry.TABLE_NAME, null, values)
        }
    }

private inline fun <T> SQLiteDatabase.transaction(function: SQLiteDatabase.() -> T): T{
    beginTransaction()
    val result = try{
        val returnValue = function()
        setTransactionSuccessful()
        returnValue
    } finally{
        endTransaction()
    }
    close()
    return result
}
}