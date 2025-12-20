package org.example5
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    //Without any parameter it will take confined dispatcher and take context from the immediate parent
     launch{
         println("C1::${Thread.currentThread().name}") // This will be running on the main thread
         delay(1000)
         println("C2::${Thread.currentThread().name}")
     }

    /*
    Here Dispatchers.Defailt is--->
    A shared background thread pool
    Optimized for CPU bound work
    Uses a number of threads
    */

    launch(Dispatchers.Default){
        println("This is running on :${Thread.currentThread().name}")
        delay(1000)
        println("This is running on after delay:${Thread.currentThread().name}") // The thread can be changed and if both the print lines show the same background thread then it is just a coincidence
    }

    launch(Dispatchers.Unconfined){
        println("C3:: Thread is ${Thread.currentThread().name}")
        delay(100)
        println("C3 after the delay:${Thread.currentThread().name}")
    }

    launch(coroutineContext){ //The property of the immediate parent-->it will basically pass the context of the immediate parent that means it will be running on the main thread
        println("This is running on :${Thread.currentThread().name}")
        delay(1000)
        println("This is running on:${Thread.currentThread().name}")
    }
}



