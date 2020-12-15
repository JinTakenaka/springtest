package com.example.demo.service

import com.example.demo.mapper.TodoMapper
import com.example.demo.model.SampleModel
import com.example.demo.model.TodoModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService(private val mapper: TodoMapper) {

    fun find() : List<TodoModel> = mapper.find()
    fun insert(title:String) = mapper.insert(title)
    //fun insert(model: SampleModel) = mapper.insert(model)
    fun update(id:Int, hello_world:String) = mapper.update(id, hello_world)
    fun delete(id:Int) = mapper.delete(id)
    fun deleteAll() = mapper.deleteAll()
}