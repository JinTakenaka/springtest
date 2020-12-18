package com.example.demo.model

import java.util.Date

class TodoModel(
    var id: Char,
    var title: String,
    var categoryId: Int,
    var detail: String,
    var statusId: Int,
    var deadline: Date,
    var remarks: String
)

//class SampleModel{
//    private var id:Int = 0
//    private var helloWorld:String = ""
//
//    constructor(){
//        this.id = 0
//        this.helloWorld = "hello"
//    }
//
//    constructor(id:Int, hello_world:String){
//        this.id = id
//        this.helloWorld = helloWorld
//    }
//}