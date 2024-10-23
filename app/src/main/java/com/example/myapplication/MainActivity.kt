package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var textViewStatus: TextView
    private lateinit var textViewName: TextView
    private lateinit var textViewWinner: TextView
    private lateinit var textViewPlayerPlayed: TextView
    private lateinit var textViewComputerPlayed: TextView
    private lateinit var radioButtonScissors: RadioButton
    private lateinit var radioButtonRock: RadioButton
    private lateinit var radioButtonPaper: RadioButton
    private lateinit var buttonPlay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect XML views to Kotlin objects
        editTextName = findViewById(R.id.editTextName)
        textViewStatus = findViewById(R.id.TextViewStatus)
        textViewName = findViewById(R.id.textViewName)
        textViewWinner = findViewById(R.id.textViewWinner)
        textViewPlayerPlayed = findViewById(R.id.textViewPlayerPlayed)
        textViewComputerPlayed = findViewById(R.id.textViewComputerPlayed)
        radioButtonScissors = findViewById(R.id.radioButtonScissors)
        radioButtonRock = findViewById(R.id.radioButtonRock)
        radioButtonPaper = findViewById(R.id.radioButtonPaper)
        buttonPlay = findViewById(R.id.buttonPlay)

        buttonPlay.setOnClickListener {
            // Check if the name input is empty
            if (editTextName.length() < 1) {
                textViewStatus.text = "請輸入玩家姓名"
            } else {
                // Display player's name
                textViewName.text = "名字\n${editTextName.text}"

                // Determine player's choice
                textViewPlayerPlayed.text = when {
                    radioButtonScissors.isChecked -> "我出拳\n剪刀"
                    radioButtonRock.isChecked -> "我出拳\n石頭"
                    else -> "我出拳\n布"
                }

                // Generate computer's choice using random number (0 = Scissors, 1 = Rock, 2 = Paper)
                val computerChoice = (Math.random() * 3).toInt()
                textViewComputerPlayed.text = when (computerChoice) {
                    0 -> "電腦出拳\n剪刀"
                    1 -> "電腦出拳\n石頭"
                    else -> "電腦出拳\n布"
                }

                // Determine the winner
                when {
                    (radioButtonScissors.isChecked && computerChoice == 2) ||
                            (radioButtonRock.isChecked && computerChoice == 0) ||
                            (radioButtonPaper.isChecked && computerChoice == 1) -> {
                        textViewWinner.text = "勝利者\n${editTextName.text}"
                        textViewStatus.text = "恭喜您獲勝了！！！"
                    }
                    (radioButtonScissors.isChecked && computerChoice == 1) ||
                            (radioButtonRock.isChecked && computerChoice == 2) ||
                            (radioButtonPaper.isChecked && computerChoice == 0) -> {
                        textViewWinner.text = "勝利者\n電腦"
                        textViewStatus.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        textViewWinner.text = "勝利者\n平手"
                        textViewStatus.text = "平局，請再試一場！"
                    }
                }
            }
        }
    }
}