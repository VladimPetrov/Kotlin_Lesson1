package ru.gb.kotlin_lesson1.Domain

class GameEngine {
    var counterRound : Int = 0
    var storageWords : Storage
    init {
        storageWords = Storage(arrayListOf("apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato") )
    }
    fun incRound() {
        counterRound++
        when (counterRound) {
            1 -> storageWords.initSecretWord()
            4 -> counterRound = 0
        }
    }
    fun isVictory(playerWord : String) : Boolean {
        val isVictory = (playerWord.equals(storageWords.secretWord))
        if (isVictory) counterRound = 0
        return isVictory
    }
    fun getSecret() : String { return storageWords.secretWord }
}