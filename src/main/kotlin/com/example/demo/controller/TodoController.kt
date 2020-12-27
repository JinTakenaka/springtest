package com.example.demo.controller

import com.example.demo.controller.dto.TodoDeleteRequest
import com.example.demo.controller.dto.TodoGetTodolRequest
import com.example.demo.controller.dto.TodoInsertRequest
import com.example.demo.controller.dto.TodoUpdateRequest
import com.example.demo.model.TodoListModel
import com.example.demo.model.TodoModel
import com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.*

//@Controller
@RestController
@RequestMapping("todo")
class TodoController(
    private var todoService: TodoService
    ) {

    @GetMapping("/find")//詳細一覧確認用
    fun find(): List<TodoModel>  {
        println("GET_TODO_LIST")
        return todoService.find()
    }

    @PostMapping("/insert")//登録API
    fun insertData(@RequestBody body:TodoInsertRequest): Boolean {
        println("INSERT")
        var id = todoService.insert(body.title, body.category, body.detail, body.deadline, body.remarks)
        return id=="false"
    }

    @GetMapping("/getTodo")//詳細取得API
    fun getTodo(@RequestBody body:TodoGetTodolRequest):TodoModel{
        println("GET_TODO")
        return todoService.getTodoById(body.id)
    }

    @GetMapping("/getTodoList")//一覧取得API
    fun getTodoList(): List<TodoListModel>  {
        println("GET_TODO_LIST")
        return todoService.getTodoList()
    }

    @PutMapping("/update")//更新API
    fun updateData(@RequestBody body:TodoUpdateRequest) : Boolean {
        println("UPDATE")
        return todoService.update(body.id, body.status)
    }

    @DeleteMapping("/delete")//削除API
    fun deleteData(@RequestBody body:TodoDeleteRequest): Boolean{
        println("DELETE")
        return todoService.delete(body.id)
    }
}