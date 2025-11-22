package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main() {
    println("Main program starts:${Thread.currentThread().name}")
    System.out.flush()

    thread {
        println("Fake work starts:${Thread.currentThread().name}")
        System.out.flush()
        Thread.sleep(10000)
        println("Fake work ends:${Thread.currentThread().name}")
        System.out.flush()
    }

    println("Main programs ends:${Thread.currentThread().name}")
    System.out.flush()
}
