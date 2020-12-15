package com.example.demo.controller

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
//    @PostMapping("/insert/{hello_world}")
//    fun insertData(@PathVariable hello_world:String): List<SampleModel>  {
    fun insertData(@RequestBody body:TodoModel): List<TodoModel>  {
//    fun insertData(@RequestBody model: SampleModel): List<SampleModel>  {
        println("WWW2")
        todoService.insert(body.title)
//        TodoService.insert(hello_world)
        return todoService.find()
    }

    @PutMapping("/update/{id}/{hello_world}")
    fun updateData(@PathVariable("id") id:Int,@PathVariable("hello_world") hello_world:String) : List<TodoModel> {
        println("www3")
//        TodoService.update(id, hello_world)
        return todoService.find()
    }

    @DeleteMapping("/delete/{id}")
    fun deleteData(@PathVariable id:Int): List<TodoModel> {
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