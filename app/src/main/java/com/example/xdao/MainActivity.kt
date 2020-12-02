package com.example.xdao

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(),  View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button

    private var FirstPlayer = ArrayList<Int>()
    private var SecondPlayer = ArrayList<Int>()

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()


    }

    
    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetbutton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }



    override fun onClick(ClickedView: View?) {
        if (ClickedView is Button) {

            var buttonNumber = 0
            when (ClickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame (buttonNumber, ClickedView)
            }

        }
    }



    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text ="X"
            clickedView.setTextColor(Color.RED)
            clickedView.setBackgroundColor(Color.WHITE)
            FirstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "0"
            clickedView.setTextColor(Color.BLUE)
            clickedView.setBackgroundColor(Color.WHITE)
            SecondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun  check() {
        var winnerPlayer = 0
        if(FirstPlayer.contains(1) && FirstPlayer.contains(2) && FirstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(1) && SecondPlayer.contains(2) && SecondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if(FirstPlayer.contains(4) && FirstPlayer.contains(5) && FirstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(4) && SecondPlayer.contains(5) && SecondPlayer.contains(6)) {

            winnerPlayer = 2
        }

        if(FirstPlayer.contains(7) && FirstPlayer.contains(8) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(7) && SecondPlayer.contains(8) && SecondPlayer.contains(9)) {

            winnerPlayer = 2
        }

        if(FirstPlayer.contains(1) && FirstPlayer.contains(4) && FirstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(1) && SecondPlayer.contains(4) && SecondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if(FirstPlayer.contains(2) && FirstPlayer.contains(5) && FirstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(2) && SecondPlayer.contains(5) && SecondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if(FirstPlayer.contains(3) && FirstPlayer.contains(6) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(3) && SecondPlayer.contains(6) && SecondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if(FirstPlayer.contains(1) && FirstPlayer.contains(5) && FirstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(1) && SecondPlayer.contains(5) && SecondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if(FirstPlayer.contains(3) && FirstPlayer.contains(5) && FirstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if(SecondPlayer.contains(3) && SecondPlayer.contains(5) && SecondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (winnerPlayer != 0) {
            if (winnerPlayer == 1){
                Toast.makeText(this,"X Wins", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"0 Wins", Toast.LENGTH_LONG).show()
            }
            disableButtons()
        }

    }

    private  fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }


}