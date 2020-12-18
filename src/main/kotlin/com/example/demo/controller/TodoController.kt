package com.example.demo.controller

import com.example.demo.controller.dto.TodoInsertRequest
import com.example.demo.model.TodoModel
import com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.*

//@Controller
@RestController
@RequestMapping("todo")
class TodoController(
    private var todoService: TodoService
    ) {

    @GetMapping("/list")
    fun index(): List<TodoModel>  {
        println("www")
//        val modelList = sampleService.find()
        return todoService.find()
    }

    @PostMapping("/insert")
    fun insertData(@RequestBody body:TodoInsertRequest): Boolean {
        println("INSERT")
        return todoService.insert(body.title, body.category, body.detail, body.deadline, body.remarks)
    }

    @PutMapping("/update/{id}/{hello_world}")
    fun updateData(@PathVariable("id") id:Char,@PathVariable("title") title:String) : List<TodoModel> {
        println("www3")
//        TodoService.update(id, hello_world)
        return todoService.find()
    }

    @DeleteMapping("/delete/{id}")
    fun deleteData(@PathVariable id:Char): List<TodoModel> {
        println("WWW4")
//        TodoService.delete(id)
        return todoService.find()
    }

    @DeleteMapping("/delete/all")
    fun deleteAllData(): List<TodoModel> {
        println("WWW5")
//        TodoService.deleteAll()
        return todoService.find()
    }
}