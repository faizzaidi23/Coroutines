package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){

    println("Main program starts:${Thread.currentThread().name}") //This executes on the main thread


    thread{ //This is the background thread which is running on parallel on the main thread
        println("Fake work starts:${Thread.currentThread().name}")
        Thread.sleep(1000) //Pretending to do some work on the background thread like the file upload
        println("Fake work ends:${Thread.currentThread().name}")
    }

    println("Main programs ends:${Thread.currentThread().name}")
}

