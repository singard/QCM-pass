package com.ynov.qcm_pass.model

import java.util.*

class Stat {
    var id: Int = 0
    var date: String = ""
    var goodAnswerPercentage: Float = 10.0F

    constructor(date: String, goodAnswerPercentage: Float) {
        this.date = date
        this.goodAnswerPercentage = goodAnswerPercentage
    }

    constructor() {
    }
}