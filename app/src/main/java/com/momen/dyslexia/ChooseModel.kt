package com.momen.dyslexia

class ChooseModel {
    var question: String = ""
    var ans1: String = ""
    var ans2: String = ""
    var ans3: String = ""
    var ans4: String = ""
    var realAns: String = ""

    constructor(
        question: String,
        ans1: String,
        ans2: String,
        ans3: String,
        ans4: String,
        realAns: String
    ) {
        this.question = question
        this.ans1 = ans1
        this.ans2 = ans2
        this.ans3 = ans3
        this.ans4 = ans4
        this.realAns = realAns
    }
}