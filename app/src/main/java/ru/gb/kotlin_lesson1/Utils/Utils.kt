package ru.gb.kotlin_lesson1.Utils

    fun findChar(searchWord : String, modelWord : String) : String {
        var shadowWord = ""
        var minLength : Int = if (searchWord.length <= modelWord.length) searchWord.length - 1 else modelWord.length - 1
        for (i in 0..minLength) {
            shadowWord += if (searchWord[i] == modelWord[i]) searchWord[i] else '#'
        }
        for (i in minLength..15) {
            shadowWord += '#'
        }
        return shadowWord
    }

