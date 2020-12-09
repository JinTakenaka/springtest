package com.example.demo.controller

import com.example.demo.service.HelloWorldService
import org.springframework.web.bind.annotation.*

@RestController
class HelloWorldController(private val service: HelloWorldService) {
    @GetMapping("/hello-worlds/{id}")
    fun getHelloWorld(@PathVariable("id") id: Int) = service.getHelloWorld(id)

    @GetMapping("/hello-worlds")
    //@GetMapping("/")
    fun getHelloWorldList() = service.getHelloWorldList()
    //    fun hello(@RequestParam(value = "name", required = false, defaultValue = "world")name:String):String{
//        return "hello, $name!"
//    }
    @PostMapping("/hello-worlds")
    //@PostMapping("/")
    fun saveHelloWorld(@RequestParam("message") message: String) =
        service.insertHelloWorld(message)
}