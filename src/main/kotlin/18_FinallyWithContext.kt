package org.example


import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
withContext switches the coroutine to a new context
NonCancellable is a special job
The job ignores the cancellation
*/

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
        }finally {
            withContext(NonCancellable){ // This temporarily tells the coroutine:"Ignore the cancellation for this block so cleanup can finish"
                delay(1000)
                println("This closes the resources finally")
            }
        }
    }
    delay(50)
    job.cancel()
    println("Ending the main function and this is ending on the:${Thread.currentThread().name}")
}