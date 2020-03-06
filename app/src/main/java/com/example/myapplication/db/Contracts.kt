package com.example.myapplication.db

import android.provider.BaseColumns

val DATABASE_NAME = "habit.db"
val DATABASE_VERSION = 10

object HabitEntry : BaseColumns{
    val TABLE_NAME = "habit"
    val TITLE_COL = "title"
    val DESC_COL = "description"
    val _ID = "id"

}