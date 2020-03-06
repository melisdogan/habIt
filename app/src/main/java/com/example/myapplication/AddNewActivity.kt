package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.db.HabitDbTable

class AddNewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)
        val saveButton = findViewById<Button>(R.id.button)
        saveButton.setOnClickListener {
            storeHabit(it)
        }
    }
    fun storeHabit(v: View){
        val title = findViewById<EditText>(R.id.title_text_Box).text.toString()
        val desc = findViewById<EditText>(R.id.desc_text_box).text.toString()
        HabitDbTable(this).store(Habit(title, desc))
        startActivity(Intent(this, MainActivity::class.java))
    }

}
