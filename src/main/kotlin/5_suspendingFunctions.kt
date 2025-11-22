package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


fun main()= runBlocking {
    println("Starting the task:${Thread.currentThread().name}}")
    GlobalScope.launch {
        println("Starting the fake task:${Thread.currentThread().name}")
        mySuspendFun(1000)
        println("Fake work finished:${Thread.currentThread().name}")
    }
    mySuspendFun(2000) //main thread:wait for the coroutine to finish its task
}

suspend fun mySuspendFun(time: Long){
    delay(time)
}