package com.example.demo.service

import com.example.demo.mapper.SampleMapper
import com.example.demo.model.SampleModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SampleService(private val mapper: SampleMapper) {

    fun find() : List<SampleModel> = mapper.find()
    fun insert(hello_world:String) = mapper.insert(hello_world)
    //fun insert(model: SampleModel) = mapper.insert(model)
    fun update(id:Int, hello_world:String) = mapper.update(id, hello_world)
    fun delete(id:Int) = mapper.delete(id)
    fun deleteAll() = mapper.deleteAll()
}