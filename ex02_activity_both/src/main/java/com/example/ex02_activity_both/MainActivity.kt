package com.example.ex02_activity_both

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt1 = findViewById<EditText>(R.id.edtNum1)
        var edt2 = findViewById<EditText>(R.id.edtNum2)
        var btn1 = findViewById<Button>(R.id.btnNewActivity)

        var rg1 = findViewById<RadioGroup>(R.id.rg1)

        //라디오버튼은 바인딩 필요 없음! 왜? 변화를 안시키니까
        //var rdo1 =


        btn1.setOnClickListener {
            var intent1 = Intent(applicationContext, SecondActivity::class.java)

            intent1.putExtra("Num1", edt1.text.toString().toInt())
            intent1.putExtra("Num2", edt2.text.toString().toInt())

            when(rg1.checkedRadioButtonId)
            {
                R.id.rdo1 -> intent1.putExtra("Operator", "+")
                R.id.rdo2 -> intent1.putExtra("Operator", "-")
                R.id.rdo3 -> intent1.putExtra("Operator", "*")
                R.id.rdo4 -> intent1.putExtra("Operator", "/")
            }

            startActivityForResult(intent1, 0)//양방향으로 보냄,그러면 받았을 때 해야할 일을 구현해줘야함(onActivityResult()메소드)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent1: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent1)

        if(resultCode == Activity.RESULT_OK)
        {
            var hap = intent1!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "합계$hap", Toast.LENGTH_SHORT).show()
        }
    }
}