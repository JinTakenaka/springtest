package com.example.demo.service

import com.example.demo.infrastructure.mapper.SampleMapper
import com.example.demo.model.SampleModel
import org.springframework.stereotype.Service

@Service
class SampleService(private val mapper: SampleMapper) {

    fun find() : List<SampleModel> = mapper.find()
    fun insert(helloWorld:String) = mapper.insert(helloWorld)
//    fun insert(model: SampleModel) = mapper.insert(model)
//    fun insert(model: SampleModel) = mapper.insert(model.getHelloWorld())
    fun update(id:Int, hello_world:String) = mapper.update(id, hello_world)
    fun delete(id:Int) = mapper.delete(id)
    fun deleteAll() = mapper.deleteAll()
}