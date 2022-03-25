package com.example.ex01_picture_vote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        var intent1 = intent //보내온 intent를 여기 intent1에 넣음(정확히는 참조)

        //intent안에는 엑스트라 2개 있음, 1)그림이름배열, 2)득표수배열
        //넘어온 exrtra를 닮을 변수를 만들어야 함! -> 이상화에서는 배열 2개 만들어야함(String배열, Int배열)
        //만들기 귀찮음, 그래서 바로 담아 버림~!
        var imgNameArr = intent1.getStringArrayExtra("ImageNameArr")
        var voteArr = intent1.getIntArrayExtra("VoteArr")

        //문제풀기: 최대값 구하기 1
//        var max = 0
//        var max_index = 0
//        for(i in 0..voteArr!!.size-1)
//        {
//            if(max <voteArr[i]) //최대값과 현재값을 비교해서, 현재값이 크면
//            {
//                max = voteArr[i] //최대값을 갱신한다. 현재값으로
//                max_index = i
//            }
//        }

        //문제풀기: 최대값 구하기 2:max없이 구하기
//        var max = 0
        var max_index = 0
        for(i in 0..voteArr!!.size-1)
        {
            if(voteArr[max_index] <voteArr[i]) //최대값과 현재값을 비교해서, 현재값이 크면
            {
//                max = voteArr[i] //최대값을 갱신한다. 현재값으로
                max_index = i
            }
        }

        var tvTop = findViewById<TextView>(R.id.tvTop)
        var ivTop = findViewById<ImageView>(R.id.ivTop)

        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                                  R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                                  R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)

        tvTop.setText(imgNameArr!![max_index])
        ivTop.setImageResource(imageFileId[max_index])

        //객체 만들고, 바인딩 하는 기본작업 실시
//        var tv1 = findViewById<TextView>(R.id.tv1)
//        var tv2 = findViewById<TextView>(R.id.tv2)

        var tvIdArr = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3,
                              R.id.tv4, R.id.tv5, R.id.tv6,
                              R.id.tv7, R.id.tv8, R.id.tv9 )
        var tvArr = arrayOfNulls<TextView>(9)
        for(i in 0..tvArr.size-1)
            tvArr[i] = findViewById<TextView>(tvIdArr[i])

//        var rb1 = findViewById<RatingBar>(R.id.rbar1)
//        var rb2 = findViewById<RatingBar>(R.id.rbar2)

        var rbIdArr = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3,
                              R.id.rbar4, R.id.rbar5, R.id.rbar6,
                              R.id.rbar7, R.id.rbar8, R.id.rbar9)
        var rbArr = arrayOfNulls<RatingBar>(9)
        for(i in 0..rbArr.size-1)
            rbArr[i] = findViewById(rbIdArr[i])

        for(i in 0..(voteArr!!.size-1))
        {
            tvArr[i]!!.setText(imgNameArr!![i])
            rbArr[i]!!.rating = voteArr[i].toFloat()
        }

        var btnFinish = findViewById<Button>(R.id.btnReturn)

        btnFinish.setOnClickListener {
            finish()
        }
    }
}