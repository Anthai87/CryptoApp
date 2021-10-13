package com.example.mycryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addNumbers(2,2)

    }

    private fun addNumbers(num1: Int, num2: Int){
        val sum = num1 + num2
        textView.text = "$sum"

    }
}