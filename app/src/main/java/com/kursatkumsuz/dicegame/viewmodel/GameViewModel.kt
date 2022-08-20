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
    var playerClick : Int = 0
    private var firstPlayerDieValue: Int = 0
    private var secondPlayerDieValue: Int = 0

    fun rollFirstPlayerDie() {
        firstPlayerDieValue = Random().nextInt(6) + 1
        firstImageResource = when (firstPlayerDieValue) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }
        playerClick ++
    }

    fun rollSecondPlayerDie() {
        secondPlayerDieValue = Random().nextInt(6) + 1
        secondImageResource = when (secondPlayerDieValue) {
            1 -> R.drawable.ic_dice_1
            2 -> R.drawable.ic_dice_2
            3 -> R.drawable.ic_dice_3
            4 -> R.drawable.ic_dice_4
            5 -> R.drawable.ic_dice_5
            else -> R.drawable.ic_dice_6
        }
        playerClick ++
    }

    fun setRound() {
        if(playerClick > 2) {
            playerClick = 1
        } else if(playerClick == 2) {
            addScore()
        }
    }

    private fun addScore() {
        if (firstPlayerDieValue > secondPlayerDieValue) {
            firstPlayerScore++
        } else if (secondPlayerDieValue > firstPlayerDieValue) {
            secondPlayerScore++
        }
    }
}