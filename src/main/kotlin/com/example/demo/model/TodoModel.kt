package com.example.demo.model

import javax.xml.crypto.Data

class TodoModel(
    var id: Char,
    var title: String,
    var category_id: Int,
    var detail: String,
    var status_id: Int,
    var deadline: Data,
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