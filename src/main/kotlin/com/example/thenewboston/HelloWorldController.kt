package com.example.thenewboston

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {
    @GetMapping
    fun helloWorld() :String = "Hello, this is a REST endpoint!"

    @GetMapping("/name")
    fun Name() : String ="My Name is Anmol and i am learning to make rest API's"
}