package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("This is the starting and this runs on :${Thread.currentThread().name}")
    val job: Job=launch{
        println("This is the child coroutine and this runs on:${Thread.currentThread().name}")
        for(i in 0..100){
            println("$i.")
            delay(50)
        }
    }
    delay(200)
    job.cancelAndJoin()
    println("Main program ends and this ends on the thread:${Thread.currentThread().name}")

}