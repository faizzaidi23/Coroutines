package org.example.CoroutineBuilders

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("Main Program starts:${Thread.currentThread().name}")
    val jobDeferred: Deferred<Int> = GlobalScope.async{//runs on a background thread
        println("Fake work starts:${Thread.currentThread().name}")
        delay(1000)
        println("Fake work ends:${Thread.currentThread().name}")
        15
    }
    val num:Int=jobDeferred.await() // await() means-->suspend coroutine until the async result is ready
    println("Main program ends:${Thread.currentThread().name}")
}

suspend fun myOwnSuspendingFunction(){
    delay(1000)
}

