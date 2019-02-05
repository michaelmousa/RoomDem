package com.treehouse.roomdemo.Data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personDao():PersonDao
}