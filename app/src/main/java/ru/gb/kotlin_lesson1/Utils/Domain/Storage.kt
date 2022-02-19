package ru.gb.kotlin_lesson1.Utils.Domain

import kotlin.random.Random

data class Storage(val listWords : ArrayList<String>) {
    private var secretWord : String
    init {
        var rand : Random = Random
        secretWord = listWords.get(rand.nextInt(listWords.size))
    }

}