package com.example.demo.controller

import com.example.demo.controller.dto.TodoGetDetailRequest
import com.example.demo.controller.dto.TodoInsertRequest
import com.example.demo.controller.dto.TodoUpdateRequest
import com.example.demo.model.TodoListModel
import com.example.demo.model.TodoModel
import com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.*
import java.util.*

//@Controller
@RestController
@RequestMapping("todo")
class TodoController(
    private var todoService: TodoService
    ) {

    @GetMapping("/find")
    fun find(): List<TodoModel>  {
        println("GET_TODO_LIST")
//        val modelList = sampleService.find()
        return todoService.find()
    }

    @PostMapping("/insert")
    fun insertData(@RequestBody body:TodoInsertRequest): Boolean {
        println("INSERT")
        return todoService.insert(body.title, body.category, body.detail, body.deadline, body.remarks)
    }

    @PostMapping("/getTodo")
    fun getTodo(@RequestBody body:TodoGetDetailRequest):TodoModel{
        println("GET_TODO")
        return todoService.getTodoById(body.id)
    }

    @GetMapping("/getTodoList")
    fun getTodoList(): List<TodoListModel>  {
        println("GET_TODO_LIST")
//        val modelList = sampleService.find()
        return todoService.getTodoList()
    }

    @PutMapping("/update")
    fun updateData(@RequestBody body:TodoUpdateRequest) : Boolean {
        println("UPDATE")
        return todoService.update(body.id, body.status)
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