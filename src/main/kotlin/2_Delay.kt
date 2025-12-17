package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("Main programs starts:${Thread.currentThread().name}")
    GlobalScope.launch { //creates a new coroutine that does not block the thread on which it is operating
        println("Fake work starts:${Thread.currentThread().name}")
        delay(1000) //Coroutine is suspended but the thread:T1 is free i.e that is not blocked
        println("Fake work finished:${Thread.currentThread().name}") //Either T1 or some other thread
    }

    runBlocking { //creates a coroutine that blocks the current thread here it will be blocking the main thread but if it was inside the GlobalScope then it will be blocking the background thread on which that particular coroutine will be running
        delay(2000)
        println("This is running on:${Thread.currentThread().name}")
    }

    println("Main program ends:${Thread.currentThread().name}")
}