package com.example.demo

import org.springframework.data.repository.CrudRepository

interface HelloWorldRepository : CrudRepository<HelloWorld, Int>