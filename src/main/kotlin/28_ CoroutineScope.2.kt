import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
we need a coroutineScope{} only when we are inside a suspending function that is not already a scope

async is not a top level entry point
it can only be used inside an existing coroutineScope


because async is an extension function
it can only be called on a CoroutineScope


runBlocking creates a coroutineScope while async does not

async is not a coroutineScope
async is a coroutineBuilder that uses a coroutineScope


Then why is async called "coroutineBuilder"

because "coroutineBuilder" does not mean "scope Builder"

Correct definition--> A coroutine builder is a function that creates a coroutine

It does not mean it creates a scope
or it creates a thread
or that is an entry point


Talking more precisely--->

Async creates a child coroutine
Attaches it to an existing CoroutineScope
Returns a handle(deferred)

*/

fun main(){
    // removed the Android / JVM-internal imports and TAG usage
    // doAction no longer needs a View parameter for this JVM example
    fun doAction(){
        CoroutineScope(Dispatchers.IO).launch{
            // Use println on the JVM instead of Android Log.d
            println("Thread: ${Thread.currentThread().name}")
        }
    }

    doAction()
    // Keep the JVM alive briefly so the coroutine can run
    Thread.sleep(200)
}