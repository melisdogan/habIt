package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add_new.view.*

class HabitsAdapter(val habits: List<Habit>): RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return HabitViewHolder(view)
    }

    override fun getItemCount(): Int = habits.size

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
            holder.card.findViewById<TextView>(R.id.mainText).text = habits[position].title
            holder.card.findViewById<TextView>(R.id.descText).text = habits[position].description
            holder.itemView.setOnClickListener{
                val intent = Intent(,ChronoActivity::class.java)
            }
    }

    class HabitViewHolder(val card: View) : RecyclerView.ViewHolder(card)

}