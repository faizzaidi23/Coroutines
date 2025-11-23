package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//To cancel a coroutine it has to be cooperative
/*
Periodically invoke a suspending function that checks for cancellation

Only those suspending functions that belongs to kotlinx.coroutines package will make
coroutine cooperative


*/


fun main()= runBlocking {
    println("Main function starts:${Thread.currentThread().name}")

    val job: Job =launch{
        for(i in 0..500){
            println("$i")
            Thread.sleep(50)
        }
    }
    job.cancel()
    job.join()
    println("Main program ends:${Thread.currentThread().name}")
}