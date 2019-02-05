package com.treehouse.roomdemo

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.treehouse.roomdemo.Data.Person
import com.treehouse.roomdemo.Data.PersonDatabase
import com.treehouse.roomdemo.ui.HomeContract
import com.treehouse.roomdemo.ui.HomePresenter
import com.treehouse.roomdemo.ui.PeopleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_person.*

class MainActivity<onItemClickListener> : AppCompatActivity(), HomeContract.View {

    lateinit var homePresenter: HomeContract.Presenter
    private val peopleAdapter = PeopleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val personDatabase = Room.databaseBuilder<PersonDatabase>(applicationContext,
            PersonDatabase::class.java,"")
            .build()

        homePresenter = HomePresenter(personDatabase, this)

        homePresenter.getPeople()

        val linearLayoutManager = LinearLayoutManager(this)
        rvPeople.layoutManager = linearLayoutManager
        rvPeople.adapter = peopleAdapter

        btnSave.setOnClickListener {
            homePresenter.addPerson(name = etName.text.toString(), age = etAge.text.toString(),
                email = etEmail.text.toString() , gender = etGender.text.toString(), country = etCountry.text.toString())
        }

    }

    override fun showPeople(people: List<Person>) {
        peopleAdapter.setData(people)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPersonDetails (name: String, age: String, email: String, gender: String, country: String) {
        this.tvName.text = name
        this.tvAge.text = age
        this.tvEmail.text = email
        this.tvGender.text = gender
        this.tvCountry.text = country
    }

    override fun onStop() {
        super.onStop()
        homePresenter.stop()
    }

    override fun onItemClicked(person: Person){
        homePresenter.onPersonSelected(person)
    }
}
