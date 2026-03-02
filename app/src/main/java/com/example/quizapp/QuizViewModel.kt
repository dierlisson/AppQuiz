package com.example.quizapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizViewModel : ViewModel() {
    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex.asStateFlow()

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score.asStateFlow()

    val totalQuestions = androidQuizQuestions.size

    fun getCurrentQuestion(): Question = androidQuizQuestions[_currentIndex.value]

    fun submitAnswer(selectedIndex: Int): Boolean {
        val isCorrect = selectedIndex == getCurrentQuestion().correctAnswerIndex
        if (isCorrect) {
            _score.value += 1
        }

        return if (_currentIndex.value < totalQuestions - 1) {
            _currentIndex.value += 1
            true // Tem mais perguntas
        } else {
            false // Fim do quiz
        }
    }

    fun resetQuiz() {
        _currentIndex.value = 0
        _score.value = 0
    }
}