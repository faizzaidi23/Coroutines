package org.example.withTimeoutOrNUll

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main()= runBlocking {
    println("Starting the main function and this runs on :${Thread.currentThread().name}")

    withTimeoutOrNull(2000){
        println("This is running on:${Thread.currentThread().name}")
        for(i in 0..500){
            println("$i.")
            delay(100)
        }
        println("Since we are using withTimeoutOrNull we will not get any exception") // this line will not get printed probably since the for loop will take the whole time and all the numbers till 500 will not get printed too
        println("Thie runs on:${Thread.currentThread().name}")
    }
    println("Main function ends on:${Thread.currentThread().name}")
}