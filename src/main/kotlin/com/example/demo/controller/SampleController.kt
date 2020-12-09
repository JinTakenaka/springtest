package com.example.demo.controller

import com.example.demo.model.SampleModel
import com.example.demo.service.SampleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//@Controller
@RestController
class SampleController(
    private var sampleService: SampleService
) {

    @GetMapping("/")
    fun index(): List<SampleModel>  {
        println("www")
        //val modelList = sampleService.find()
        return sampleService.find()
    }
}