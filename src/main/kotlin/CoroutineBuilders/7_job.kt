package org.example.CoroutineBuilders

import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
What is a job-->
A job is a handle(object) that represents a coroutine.
We can think of it like a
A reference
A controller
A task manager for the coroutine
*/

fun main()= runBlocking { //runs on the main thread
    println("main programs starts:${Thread.currentThread().name}")
    val job: Job =launch{
        println("Fake work starts:${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished:${Thread.currentThread().name}")
    }
    /*
    while the coroutine is suspended, runBlocking calls the job.join() function
    what does the join()  do-->
    It suspends the runBlocking coroutine
    which means it bocks the main thread
    Until the child coroutine finishes

    after one second coroutine resumes
    */
    // job.cancel()-->To cancel a coroutine
    /*
    we are not using delay(2000) here because
    delay is a guessing time
    using job.join() is exact,safe and reliable
    */
    job.join() //what it does is this-->It waits for the coroutine to finish
    println("Main program ends:${Thread.currentThread().name}")
}