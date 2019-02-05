package com.treehouse.roomdemo.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.treehouse.roomdemo.Data.Person
import com.treehouse.roomdemo.R

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {

    private val data = ArrayList<Person>()

    fun setData(people: List<Person>) {
        data.clear()
        data.addAll(people)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PersonViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_person,
            viewGroup,false)
        return PersonViewHolder(rootView)

    }

    override fun onBindViewHolder(personViewHolder: PersonViewHolder, position: Int) {
        personViewHolder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(person: Person) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            tvName.text = person.name

            val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
            tvAge.text = person.age.toString()

            val tvEmail = itemView.findViewById<TextView>(R.id.tvEmail)
            tvEmail.text = person.email

            val tvGender = itemView.findViewById<TextView>(R.id.tvGender)
            tvGender.text = person.Gender

            val tvCountry = itemView.findViewById<TextView>(R.id.tvCountry)
            tvCountry.text = person.country
        }

    }
}