package org.example.CoroutineBuilders

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("Main Program starts:${Thread.currentThread().name}")
    val jobDeferred: Deferred<Unit> =async{//runs on the main thread
        println("Fake work starts:${Thread.currentThread().name}")
        delay(1000)
        println("Fake work ends:${Thread.currentThread().name}")
    }
    jobDeferred.join()
    println("Main program ends:${Thread.currentThread().name}")
}