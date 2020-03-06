package com.example.myapplication

data class Habit(val title: String, val description:String)

fun getSampleHabits(): List<Habit>{
    return listOf(Habit("Test 1", "This is a short description"), Habit("Test 2", "This is a long description"))
}