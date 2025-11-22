package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(){
    println("This line executes on the:${Thread.currentThread().name}")

    /*
    The below code would not be executed without using Thread.sleep(1000) outside its scope since the main function will not wait for that background coroutine to gets executed

    also both the println statements will work on the same thread since the coroutine is working on the same thread
    and the Thread.sleep() blocks the thread for one second and then when it resumes it is on the same background thread
    */
    GlobalScope.launch { //Creates a background coroutine that runs on a background thread
        println("Fake work starts:${Thread.currentThread().name}")
        Thread.sleep(1000) //This basicaly blocks the entire thread so that if some other coroutiens in running on the same thread then it will block that too which basically violates the principle
        println("Fake work ends:${Thread.currentThread().name}")
    }
    // blocks the current main thread and wait for the coroutine to finish (practically not the right way to wait)
    Thread.sleep(2000); // With this my GlobalScope block will run perfectly fine
    println("This is the last line of the main function and this also gets executed on the:${Thread.currentThread().name}")
}