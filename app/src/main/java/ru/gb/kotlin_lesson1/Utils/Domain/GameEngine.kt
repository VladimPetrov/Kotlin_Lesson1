package ru.gb.kotlin_lesson1.Utils.Domain

class GameEngine {
    private var counterRound : Int = 0
    private var storageWords : Storage
    init {
        storageWords = Storage(listOf<String>("apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato") as ArrayList<String>)
    }
}