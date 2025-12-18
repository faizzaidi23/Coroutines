package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("This is the first  line and it executes on the:${Thread.currentThread().name}")
    val job: Job =launch{ // This will be on the main thread
        for(i in 0..500){
            print("$i.")
            delay(50)
        }
    }
    delay(200)
    job.cancel()
    job.join()
    println("Main program ends on:${Thread.currentThread().name}")
}