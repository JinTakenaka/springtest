package com.example.demo.service

import com.example.demo.HelloWorld
import com.example.demo.HelloWorldRepository
import org.springframework.stereotype.Service

@Service
class HelloWorldService(
    private val repository: HelloWorldRepository
) {
    fun getHelloWorld(id: Int) = repository.findById(id)
    fun getHelloWorldList() = repository.findAll()
    fun insertHelloWorld(message: String) = HelloWorld(message).let { repository.save(it) }
}