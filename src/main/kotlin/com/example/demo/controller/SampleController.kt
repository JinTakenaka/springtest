package com.example.demo.controller

import com.example.demo.model.SampleModel
import com.example.demo.model.insertRequest
import com.example.demo.service.SampleService
import org.springframework.web.bind.annotation.*

//@Controller
@RestController
@RequestMapping
class SampleController(
    private var sampleService: SampleService
    ) {

    @GetMapping("/")
    fun index(): List<SampleModel>  {
        println("www")
        //val modelList = sampleService.find()
        return sampleService.find()
    }

    @PostMapping("/insert")
//    @PostMapping("/insert/{hello_world}")
//    fun insertData(@PathVariable hello_world:String): List<SampleModel>  {
//    fun insertData(@RequestBody hello_world:String): List<SampleModel>  {
//    fun insertData(@RequestBody model: SampleModel): List<SampleModel>  {

    fun insertData(@RequestBody body: insertRequest): List<SampleModel>  {
        println("WWW2")
        sampleService.insert(body.helloWorld)
//        sampleService.insert(hello_world)
        return sampleService.find()
    }

    @PutMapping("/update/{id}/{hello_world}")
    fun updateData(@PathVariable("id") id:Int,@PathVariable("hello_world") hello_world:String) : List<SampleModel> {
        println("www3")
        sampleService.update(id, hello_world)
        return sampleService.find()
    }

    @DeleteMapping("/delete/{id}")
    fun deleteData(@PathVariable id:Int): List<SampleModel> {
        println("WWW4")
        sampleService.delete(id)
        return sampleService.find()
    }

    @DeleteMapping("/delete/all")
    fun deleteAllData(): List<SampleModel> {
        println("WWW5")
        sampleService.deleteAll()
        return sampleService.find()
    }
}