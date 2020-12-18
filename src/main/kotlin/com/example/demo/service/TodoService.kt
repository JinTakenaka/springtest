package com.example.demo.service

import com.example.demo.infrastructure.mapper.TodoMapper
import com.example.demo.model.TodoModel
import jdk.jfr.Category
import org.apache.ibatis.jdbc.Null
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService(private val mapper: TodoMapper) {

    fun find() : List<TodoModel> = mapper.find()
    fun insert(title:String, category:String, detail:String, deadline:Date, remarks:String): Boolean {
        val id:String = UUID.randomUUID().toString()
        return if (id!="" && title!="" && category!="" && detail!="") {
            //mapper.insert(id, title, mapper.getCategoryIdByCategory(category), detail, mapper.getStatusIdByStatus(status), deadline, remarks)
            mapper.insert(id, title, mapper.getCategoryIdByCategory(category), detail, 1, deadline, remarks)
            true
        }else false
        //return mapper.getTodoById(id)!=null
    }

    fun update(id:Char, hello_world:String) = mapper.update(id, hello_world)
    fun delete(id:Char) = mapper.delete(id)
    fun deleteAll() = mapper.deleteAll()
}