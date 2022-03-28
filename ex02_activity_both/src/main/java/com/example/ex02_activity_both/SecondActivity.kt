package com.example.ex02_activity_both

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var intent = intent

        var num1 = intent.getIntExtra("Num1", 0)
        var num2 = intent.getIntExtra("Num2", 0)

        var op1 = intent.getStringExtra("Operator")

        var hap = 0
        if(op1.equals("+"))
            hap = num1 + num2
        else if(op1.equals("-"))
            hap = num1 - num2
        else if(op1.equals("*"))
            hap = num1 * num2
        else if(op1.equals("/"))
            hap = num1 / num2

        var btn1 = findViewById<Button>(R.id.btnReturn)
        btn1.setOnClickListener {

            var intent = Intent(applicationContext, MainActivity::class.java)

            intent.putExtra("Hap", hap)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }

    }
}