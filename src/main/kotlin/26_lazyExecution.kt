import jdk.jfr.internal.consumer.EventLog.start
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking



/*
Here since we are using the Coroutine.Lazy because of this these two suspending functions will be executed only when they are being used somewhere in the application
The execution will not take place for just taking place
*/
fun main()= runBlocking {
    println("Main program starts and this runs on:${Thread.currentThread().name}")

    val msgOne: Deferred<String> = async(start= CoroutineStart.LAZY){msgOne()}
    val msgTwo: Deferred<String> = async(start= CoroutineStart.LAZY){secondMsg()}

    //println("The whole message is:${msgOne.await()+msgTwo.await()}")

    println("Main function ends on:${Thread.currentThread().name}")
}


suspend fun msgOne(): String{
    delay(1000)
    println("After working in the first function ")
    return "This is the first function "
}

suspend fun secondMsg(): String {
    delay(1000)
    println("After working in the second function ")
    return "This is the second function"
}