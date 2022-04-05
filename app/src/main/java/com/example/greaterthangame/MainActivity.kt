package com.example.greaterthangame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
  
    lateinit var iv_card1: ImageView
    lateinit var iv_card2: ImageView

    lateinit var tv_player1: TextView
    lateinit var tv_player2: TextView

    lateinit var tv_war: TextView

    lateinit var b_start: Button

    lateinit var random: Random

    var player1 = 0
    var player2 = 0

    var cardsArray = intArrayOf(
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7,
        R.drawable.img8,
        R.drawable.img9,
        R.drawable.img10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        random = Random
        
        //init objects
        iv_card1 = findViewById(R.id.iv_card1)
        iv_card2 = findViewById(R.id.iv_card2)
        
        iv_card1.setImageResource(R.drawable.back)
        iv_card2.setImageResource(R.drawable.back)

        tv_player1 = findViewById(R.id.tv_player1)
        tv_player2 = findViewById(R.id.tv_player2)

        tv_war = findViewById(R.id.tv_war)
        tv_war.visibility = View.INVISIBLE
        
        b_start = findViewById(R.id.b_start)
        b_start.setOnClickListener{
           
            //hide war label
            tv_war.visibility = View.INVISIBLE
            
            //generate cards
            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)
            
            //set image
            setCardImage(card1, iv_card1)
            setCardImage(card2, iv_card2)
            
            //compare teh cards
            if (card1 > card2) {
                player1++
                tv_player1.text = "Player 1: $player1"
            } else if (card1 < card2) {
                player2++
                tv_player2.text = "Player 2: $player2"
            } else {
                //show war label
                tv_war.visibility = View.VISIBLE
            }
            
        }
    }
    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }
}