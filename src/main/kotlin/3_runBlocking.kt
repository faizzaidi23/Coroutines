package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){  //Executes on the main thread
    runBlocking{ //Creates a coroutine  that blocks the main thread
        println("Main Program starts:${Thread.currentThread().name}") //main thread
        GlobalScope.launch {  //Runs on a background thread (This is a child coroutine)
            println("Fake work starts:${Thread.currentThread().name}")
            delay(1000)
            println("Fake work finished:${Thread.currentThread().name}")//Either T1 or any other thread
        }
        delay(2000) //main thread wait for the coroutine to finish
        println("Main Program ends:${Thread.currentThread().name}") //main thread
    }
}