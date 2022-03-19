package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "GameFragment"
private const val MODEL = "GameViewModel"

class GameViewModel : ViewModel() {
    private var _score = 0
    val score: Int
        get() = _score

    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount

    // add backing property to make the var accessible only within this view model
    private lateinit var _currentScrambledWord: String
    // UI controller can read its value using the read-only property
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    // init is called when an object instance is created
    init {
        Log.d(TAG, "$MODEL created!")
        getNextWord()
    }

    // onCleared is called right before view model is destroyed
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"$MODEL destroyed!")
    }

    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */
    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playWord: String): Boolean {
        if (playWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    /*
    * re-initialize the game data to restart the game.
     */
    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
        Log.d(TAG,"reinitialized? $_score $_currentWordCount")
    }
}