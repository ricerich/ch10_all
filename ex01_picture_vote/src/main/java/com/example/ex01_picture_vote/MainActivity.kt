package com.example.ex01_picture_vote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title ="명화 선호도 투표"

        //9개의 득표수를 각각 저장할 9칸짜리 배열 1개를 만든다.
        var voteArr = IntArray(9) //사용시에는 voteCount[i] 요런 방법으로 쓰면됨

        //9개의 그림이름을 각각 저장할 9칸짜리 배열 1개를 만든다.
        var imgNameArr = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                                 "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                                 "피아노 레슨", "피아노 앞의 소녀들", "해변에서")


//        var iv1 = findViewById<ImageView>(R.id.iv1)
//        var iv2 = findViewById<ImageView>(R.id.iv2)
//        var iv3 = findViewById<ImageView>(R.id.iv3)

        //1.ImageView 객체 배열을 만듦, for문에서 쓸려고~!
        var ivArr = arrayOfNulls<ImageView>(9)

        //2. 바인딩 해줘야함~! findViewById 를 해줘야함
        var imgIdArr = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, //바인딩하는 반복문에서 사용하기 위해서 배열로 만듦
                               R.id.iv4, R.id.iv5, R.id.iv6,
                               R.id.iv7, R.id.iv8, R.id.iv9)

        for(i in 0..(ivArr.size-1))
        {
//            ivArr[0]=findViewById<ImageView>(R.id.iv1)
//            ivArr[1]=findViewById<ImageView>(R.id.iv2)
//            ivArr[2]=findViewById<ImageView>(R.id.iv3)

            ivArr[i]=findViewById<ImageView>(imgIdArr[i])
        }

//        iv1.setOnClickListener {
//            voteCount[0]++
//            Toast.makeText(applicationContext, "총: "+voteCount[0] +" 표 득표!", Toast.LENGTH_SHORT).show()
//        }
//        iv2.setOnClickListener {
//            voteCount[1]++
//            Toast.makeText(applicationContext, "총: "+voteCount[1] +" 표 득표!", Toast.LENGTH_SHORT).show()
//        }
//        iv3.setOnClickListener {
//            voteCount[2]++
//            Toast.makeText(applicationContext, "총: "+voteCount[2] +" 표 득표!", Toast.LENGTH_SHORT).show()
//        }

        for(i in 0..(voteArr.size-1))
        {
            ivArr[i]!!.setOnClickListener {
                voteArr[i]++
                Toast.makeText(applicationContext, "총: "+voteArr[i] +" 표 득표!", Toast.LENGTH_SHORT).show()
            }
        }

        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener {
            var intent1 = Intent(applicationContext, ResultActivity::class.java)

            //엑스트라 2개를 만들어서, 1)득표수 배열, 2)그림이름 배열, intent에 꽂아서, 나중에 보내면됨
            intent1.putExtra("ImageNameArr", imgNameArr)
            intent1.putExtra("VoteArr", voteArr)

            startActivity(intent1)

        }


    }
}












