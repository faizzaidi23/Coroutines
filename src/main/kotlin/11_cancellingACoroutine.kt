package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//To cancel a coroutine it has to be cooperative
/*
Periodically invoke a suspending function that checks for cancellation

Only those suspending functions that belongs to kotlinx.coroutines package will make
coroutine cooperative

like delay(),yield(), withContext(), withTimeout() are the suspending functions that belongs to the kotlinx.coroutines package


*/


fun main()= runBlocking {
    println("Main function starts:${Thread.currentThread().name}")

    val job: Job =launch{
        println("This coroutine is on the :${Thread.currentThread().name}")
        for(i in 0..500){
            println("$i")
            Thread.sleep(50) // The coroutine will not be cancelled since we are using this Thread.sleep function which blocks the thread
        }
    }
    delay(200)
    job.cancel()
    job.join()
    println("Main program ends:${Thread.currentThread().name}")
}