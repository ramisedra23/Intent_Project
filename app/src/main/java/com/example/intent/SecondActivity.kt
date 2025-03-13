package com.example.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    var num1: Double = 0.0
    var num2: Double = 0.0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        num1 = intent.getDoubleExtra(MainActivity.EXTRA_NUM1, 0.0)
        num2 = intent.getDoubleExtra(MainActivity.EXTRA_NUM2, 0.0)
        val btn2: Button = findViewById(R.id.btn2)
        val btn1: Button = findViewById(R.id.btn1)
        val btn4: Button = findViewById(R.id.btn4)
        val btn3: Button = findViewById(R.id.btn3)
        btn2.setOnClickListener { returnResult(num1 + num2) }
        btn1.setOnClickListener { returnResult(num1 - num2) }
        btn4.setOnClickListener { returnResult(num1 * num2) }
        btn3.setOnClickListener {
            if (num2 != 0.0) returnResult(num1 / num2)
            else returnResult(Double.NaN)
        }
    }
    fun returnResult(result: Double) {
        val resultIntent = Intent().apply {
            putExtra(MainActivity.EXTRA_RESULT, result)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}