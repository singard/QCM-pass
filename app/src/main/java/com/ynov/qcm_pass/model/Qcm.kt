package com.ynov.qcm_pass.model

import java.io.Serializable

data class Qcm(
    val statement: String,
    val correctAnswers: List<String>,
    val answer: List<Answer>
): Serializable