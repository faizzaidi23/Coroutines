package org.example3
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/*

A coroutineScope defines the lifetime,context and parent child relationship of a coroutine launched inside it

Analogy would be-->Office Project Team
Think of a CoroutineScope as a project team

The team has:
A manager(job)
Working rules(Dispatchers)
Every employee(coroutine)
belongs to that team
must stop working if the project is cancelled

CoroutineScope exists to enforce structured concurrency


A coroutineScope contains-->
Job-->Controls the lifecycle,parent child relationship, cancellation propagation

Dispatcher--->which thread(s) coroutines run on either Main, IO, Default etc

Other elements-->Exception handlers, Coroutine names



Every coroutine must belong to exactly one scope

The code below is about understanding this inside the coroutines and their execution order

Inside a coroutine builder runBlocking,launch,async
this refers to the coroutineScope of that coroutine

Each coroutine has its

own CoroutineScope
its own job
possibly the same thread but different identities
*/

fun main(): kotlin.Unit = runBlocking {

    println("RunBlocking:$this ")

    launch{
        println("Launch:$this")

        launch{
            println("Child launch--->$this")
        }
    }


    async{
        println("async:$this")
    }

}