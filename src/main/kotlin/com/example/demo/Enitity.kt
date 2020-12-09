package com.example.demo

//import org.springframework.data.annotation.Id
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class HelloWorld(
    var message: String = "Hello, World!",
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
)