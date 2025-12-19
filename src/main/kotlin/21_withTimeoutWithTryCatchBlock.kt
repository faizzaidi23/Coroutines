package org.example

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main()=runBlocking{
    println("Main function starting and this is running on :${Thread.currentThread().name}")

    /*
    Even though we are using try catch and finally  block here, we will still get the exception and the program will be crashing since this is the build feature of the timeouts in kotlin
    that means either the work should be done in the specified time or the program should be crashed or stopped
    */
    withTimeout(2000){
        try{
            println("This is running on:${Thread.currentThread().name}")
            for( i in 1..500){
                println("$i.")
                delay(100)
            }
        }catch(ex: TimeoutCancellationException){ //subclass of cancellationException
                println("This is an exception condition since the time you gave was much less than the time required to completely run the coroutine")
        }finally{
            println("This is the finally block")
        }
    }

    println("Main function ends on:${Thread.currentThread().name}")
}