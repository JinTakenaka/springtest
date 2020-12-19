package com.example.demo.controller

import com.example.demo.SpringtestApplication
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.skyscreamer.jsonassert.JSONAssert.assertEquals
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

//@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
class TodoControllerTest(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun findTest(){
        //assertEquals()
    }
}