package com.kursatkumsuz.dicegame.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kursatkumsuz.dicegame.R
import java.util.*

class GameViewModel : ViewModel() {
    var firstImageResource: Int = 1
    var secondImageResource: Int = 1
    var firstPlayerScore: Int = 0
    var secondPlayerScore: Int = 0
    var playerClick: Int = 0
    private var firstPlayerDieValue: Int = 0
    private var secondPlayerDieValue: Int = 0


    fun rollFirstPlayerDie() {
        firstPlayerDieValue = Random().nextInt(6) + 1
        // Select dice by random number
        firstImageResource = when (firstPlayerDieValue) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }
        // if this function runnned by clicked, increase the playerClick's value
        playerClick++
    }

    fun rollSecondPlayerDie() {
        secondPlayerDieValue = Random().nextInt(6) + 1
        // Select dice by random number
        secondImageResource = when (secondPlayerDieValue) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }
        // if this function runnned by clicked, increase the playerClick's value
        playerClick++
    }

    fun setRound() {
        // if playerClick's value greater than 2 , make playerClick's value to 1
        if (playerClick > 2) {
            playerClick = 1

           // if playerClick's is equal to 2 , run addScore function
        } else if (playerClick == 2) {
            addScore()
        }
    }

    private fun addScore() {
        // if value of first player's die greater than other player , increase the value of the firstPlayerScore
        // otherwise increase the value of the secondPlayerScore
        if (firstPlayerDieValue > secondPlayerDieValue) {
            firstPlayerScore++

        } else if (secondPlayerDieValue > firstPlayerDieValue) {
            secondPlayerScore++
        }
    }
}