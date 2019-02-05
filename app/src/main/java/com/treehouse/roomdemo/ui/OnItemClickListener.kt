package com.treehouse.roomdemo.ui

import com.treehouse.roomdemo.Data.Person

interface OnItemClickListener {
    fun onItemClicked(person: Person)
}