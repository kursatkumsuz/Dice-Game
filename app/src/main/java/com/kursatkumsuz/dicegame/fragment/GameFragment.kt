package com.kursatkumsuz.dicegame.fragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.kursatkumsuz.dicegame.R
import com.kursatkumsuz.dicegame.databinding.FragmentGameBinding
import com.kursatkumsuz.dicegame.viewmodel.GameViewModel


class GameFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    }

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: GameViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[GameViewModel::class.java]

        binding.playerOneBtn.setOnClickListener {
            viewModel.rollFirstPlayerDie()
            binding.playerOneImageView.setImageResource(viewModel.firstImageResource)
            setScore()

        }

        binding.playerTwoBtn.setOnClickListener {
            viewModel.rollSecondPlayerDie()
            binding.playerTwoImageView.setImageResource(viewModel.secondImageResource)
            setScore()

        }
    }


    private fun setScore() {
        viewModel.setRound()
        binding.playerOneScoreText.text = "Player One: ${viewModel.firstPlayerScore}"
        binding.playerTwoScoreText.text = "Player Two: ${viewModel.secondPlayerScore}"
    }

}