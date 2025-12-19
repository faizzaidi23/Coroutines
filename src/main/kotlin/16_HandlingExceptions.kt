package org.example

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Cancellable suspending functions such as yield(), delay() etc throw CancellationException on the coroutine cancellation

We cannot execute a suspending function from the finally block because the coroutine running this code is already cancelled

If we want to execute a suspending function from a finally block then wrap the code within withContext(NonCancellable) function

*/

fun main()= runBlocking {
    println("This is the starting of the main function and this runs on:${Thread.currentThread().name}")
    val job: Job =launch(Dispatchers.Default){
        try{
            for(i in 0..100){
                println("$i.")
                delay(5)
            }
        }catch(ex: CancellationException){ //This will be executed when the request to cancel the coroutine will be made
            println("Exception caught safely")
        }finally{
            println("Close the resources in finally block")
        }
    }

    delay(10)
    job.cancelAndJoin()
    println("This is the ending of the main program and this ends on the thread:${Thread.currentThread().name}")
}