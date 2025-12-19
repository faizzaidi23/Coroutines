package org.example.withTimeoutOrNUll

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


/*
withTimeoutOrNull runs a coroutine block for a given time and returns the result if it finishes in time, otherwise it returns null instead of throwing an exception

it works like safe timeout without exception


if the block finished in time then it will be returning a value
and if not then null will be returned
*/

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