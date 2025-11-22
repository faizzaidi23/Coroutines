package org.example.CoroutineBuilders

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking { //Creates a blocking coroutine that executes in the current thread i.e  the main thread
    println("Main Program starts:${Thread.currentThread().name}") //main thread
    launch{  //Thread:main -->this is a child coroutine so its takes the scope of its parent that is the runBlocking i.e it also runs on the main Thread too
        //The GlobalScope.launch does Not inherit the parent's context it just runs on the background thread
        println("Fake work started:${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished:${Thread.currentThread().name}")
    }
    delay(2000)
    println("Main program ends:${Thread.currentThread().name}")
}