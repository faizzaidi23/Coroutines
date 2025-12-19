package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main()=runBlocking{
    println("Main program starts:${Thread.currentThread().name}")
    withTimeout(2000){
        for( i in 0..500){
            println("$i.")
            delay(500)
        }
    }
    //below line will not get printed since the coroutine will not be able to get completely executed under the given time of 2000ms
    println("Main program ends on the thread:${Thread.currentThread().name}")
}