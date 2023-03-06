package com.ynov.qcm_pass.model

import java.io.Serializable

data class Qcm(
    val statement: String,
    val correct_answers: List<String>,
    val answer: List<Answer>
): Serializable