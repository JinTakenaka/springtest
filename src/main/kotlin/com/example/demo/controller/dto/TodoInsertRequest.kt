package com.example.demo.controller.dto

import java.util.Date

data class TodoInsertRequest(
    var title: String,
    var category: String,
    var detail: String,
    var deadline: Date,
    var remarks: String
)