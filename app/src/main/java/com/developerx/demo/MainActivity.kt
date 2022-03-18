package com.developerx.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.Observable
import com.developerx.demo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        car.start()

    }
}

class Car(private var engine: Engine,val nummber:Int) {
    fun start() {
        engine.startENG()
        Log.e("strt", "$nummber car")
    }
}

class Engine @Inject constructor(val piston: Piston) {

    fun startENG() {
        piston.startPiston()
        Log.e("strt", "car ENG")
    }
}

class Piston(val numberOfPiston: NumberOfPiston) {
    fun startPiston() {
        numberOfPiston.numberP()
        Log.e("strt", "Piston")
    }
}

class NumberPis : NumberOfPiston {
    override fun numberP() {
        Log.e("strt", "Piston 4")
    }
}

interface NumberOfPiston {
    fun numberP()
}

data class DD(
    var dd: String,
    var ss: String
) : Observable {
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}