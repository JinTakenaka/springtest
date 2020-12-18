package com.example.demo.model

import java.util.Date

class TodoModel(
    var id: String,
    var title: String,
    var categoryId: Int,
    var detail: String,
    var statusId: Int,
    var deadline: Date,
    var remarks: String
)