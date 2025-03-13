package com.example.intent

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var btn1: Button
    lateinit var textView2: TextView

    companion object {
        const val REQUEST_CODE = 1
        const val EXTRA_NUM1 = "num1"
        const val EXTRA_NUM2 = "num2"
        const val EXTRA_RESULT = "result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        btn1 = findViewById(R.id.btn1)
        textView2 = findViewById(R.id.textView2)

        btn1.setOnClickListener() {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra(EXTRA_NUM1, num1)
                    putExtra(EXTRA_NUM2, num2)
                }
                startActivityForResult(intent, REQUEST_CODE)
            } else {
                textView2.text = "Please enter valid numbers"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val result = data?.getDoubleExtra(EXTRA_RESULT, 0.0)
            textView2.text = "Result: $result"
        }

    }
}
