package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main()= runBlocking {
    println("This is the starting and this runs on:${Thread.currentThread().name}")
    val job: Job =launch{
        for(i in 0..500){
            println("$i.")
            //The yield also makes the coroutine cooperative
            yield() //Suspends this coroutine and immediately schedules it for further execution.

        }
    }
    delay(20)
    job.cancelAndJoin()
    println("Main program ends here on:${Thread.currentThread().name}")
}