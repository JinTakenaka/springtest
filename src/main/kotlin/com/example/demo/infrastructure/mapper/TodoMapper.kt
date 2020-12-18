package com.example.demo.infrastructure.mapper

import com.example.demo.model.TodoListModel
import org.apache.ibatis.annotations.Mapper
import com.example.demo.model.TodoModel
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.atomic.AtomicReference

@Mapper
@Component
interface TodoMapper {

    //todoDB
    fun find(): List<TodoModel>
    fun getTodoById(id:String): TodoModel
    fun insert(id:String, title:String, categoryId:Int, detail:String, statusId:Int, deadline: Date, remarks:String): String
    fun getTodoList(): List<TodoListModel>

    fun update(id:Char, title:String)
    fun delete(id:Char)
    fun deleteAll()

    //todo_category
    fun getCategoryIdByCategory(category: String):Int

    //todo_status
    fun getStatusIdByStatus(status: String):Int
}