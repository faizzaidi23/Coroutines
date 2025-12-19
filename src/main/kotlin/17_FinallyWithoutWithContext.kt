package org.example

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("This is the main function running on:${Thread.currentThread().name}")

    val job: Job =launch{
        try{
            for(i in 1..100){
                println("$i.")
                delay(5)
            }
        }catch(ex: CancellationException){
            println("Exception caught safely")
        }finally { // This won't be executed since the exception will be executed after the cancellation and after the cancellation there is no point suspending the coroutine
            //A cancelled coroutine is not allowed to suspend anymore
            delay(1000)
            println("Closing the resources in the finally block")
        }
    }
    delay(50)
    job.cancel()
    println("Ending the main function and this is ending on the:${Thread.currentThread().name}")
}