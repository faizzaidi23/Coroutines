package org.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()= runBlocking {
    println("This is the starting and this runs on:${Thread.currentThread().name}")

    val job: Job =launch(Dispatchers.Default){ //Dispatchers.Default is a shared background thread pool meant for CPU intensive work
        for(i in 0..500){
            if(!isActive){
                return@launch//break------return@launch means Stop this coroutine completely and exit the launch block that means return from this coroutine lambda------>break means Stop only the loop not the coroutine--->after break the coroutine continues executing any code after the loop
            }
            print("$i.")
            Thread.sleep(1) // since it won't check whether there is a cancellation request or not it just checks the value of isActive if that value is false then  it will break
            // we won't be using this with the delay() or yield() function because those are cancellable that means whenever we use the delay() or yield() function it checcks for the cancellation request whether there  is a request made for the cancellation of this coroutine
        }
    }
    delay(10)
    job.cancelAndJoin()
}