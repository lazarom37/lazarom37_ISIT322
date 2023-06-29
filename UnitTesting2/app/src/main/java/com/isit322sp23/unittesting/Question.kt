package com.isit322sp23.unittesting

class Question(val correctOption: String, val incorrectOption: String) {
    var answeredOption: String? = null
    private set

    fun answer(option:String): Boolean {

        if (option != correctOption && option != incorrectOption)
            throw IllegalArgumentException("Not a Valid Option!")
        answeredOption = option
        return correctOption == answeredOption
    }
}