package com.ynov.qcm_pass.model

import java.io.Serializable

data class Answer(
    val answer_statement: String,
    val id: String
): Serializable