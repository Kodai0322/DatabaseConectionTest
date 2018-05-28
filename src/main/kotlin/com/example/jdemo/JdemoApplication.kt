package com.example.jdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JdemoApplication

fun main(args: Array<String>) {
    runApplication<JdemoApplication>(*args)
}
