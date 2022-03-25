package com.example.ch10_all

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var btn1 = findViewById<Button>(R.id.btn1)
//
//        btn1.setOnClickListener {
//            var intent1 = Intent(this, SecondActivity::class.java)
//            startActivity(intent1)
//        }

        var btn1 = findViewById<Button>(R.id.btn1)
        var rg1 = findViewById<RadioGroup>(R.id.rg1)
        var rdoSecond = findViewById<RadioButton>(R.id.rdoSecond)
        var rdoThird = findViewById<RadioButton>(R.id.rdoThird)


        btn1.setOnClickListener {

            var intent1 : Intent? = null

            when(rg1.checkedRadioButtonId)
            {
                R.id.rdoSecond -> intent1 = Intent(applicationContext, SecondActivity::class.java)
                R.id.rdoThird -> intent1 = Intent(applicationContext, ThirdActivity::class.java)
                else -> {
                    Toast.makeText(applicationContext, "선택안됨!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

//            if(rdoSecond.isChecked)
//                intent1 = Intent(applicationContext, SecondActivity::class.java)
//            else if(rdoThird.isChecked)
//                intent1 = Intent(applicationContext, ThirdActivity::class.java)
//            else //둘다 라디오 선택이 안되어 있으면
//            {
//                Toast.makeText(applicationContext, "선택안됨!", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }

            startActivity(intent1)

        }
    }
}