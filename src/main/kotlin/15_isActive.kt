package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("This is the starting and this runs on:${Thread.currentThread().name}")

    val job: Job =launch(Dispatchers.Default){
        for(i in 0..500){
            if(!isActive){
                break
            }
            print("$i.")
            Thread.sleep(1)
        }
    }
    delay(10)
    job.cancelAndJoin()
}