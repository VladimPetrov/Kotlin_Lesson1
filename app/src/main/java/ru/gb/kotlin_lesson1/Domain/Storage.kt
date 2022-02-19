package ru.gb.kotlin_lesson1.Domain

import kotlin.random.Random

data class Storage(val listWords : ArrayList<String>) {
    var secretWord : String =""

    fun initSecretWord() {
        var rand : Random = Random
        secretWord = listWords.get(rand.nextInt(listWords.size))
    }
    fun getListWordToStr() : String {
        var str : String = ""
        for (word in listWords) {
            str += word + ", "
        }
        return str
    }

}