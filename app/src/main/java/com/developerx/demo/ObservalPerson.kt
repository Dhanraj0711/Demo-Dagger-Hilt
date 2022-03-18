package com.developerx.demo

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

class ObservalPerson(pName: String, age: String) : Observable {

    @get:Bindable
    var name: String = pName
    set(value) {
        field =value
//        listener.notifyChange(this,BR.)
    }
    @get:Bindable
    var aage: String = age

    val listener:PropertyChangeRegistry= PropertyChangeRegistry()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    listener.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}