package com.treehouse.roomdemo.Data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Person {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
    @ColumnInfo(name = "personName")
    lateinit var name:String
    @ColumnInfo(name = "personAge")
    var age:Int = 0
    @ColumnInfo(name = "personEmail")
    lateinit var email:String
    @ColumnInfo(name = "Country")
    lateinit var country:String
    @ColumnInfo(name = "Gender")
    lateinit var Gender:String
}