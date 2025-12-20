import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
Here the methods inside the coroutine are executed in the sequential manner
they are getting executed one by one from top to bottom
*/

fun main()=runBlocking{

    println("The main program is starting and is running on:${Thread.currentThread().name}")

    val time= measureTimeMillis {
        val msgOne=getMessageOne()
        val msgTwo=getMessageTwo()

        println("The entire message is:${msgOne + msgTwo}")
    }

    println("Completed in time:${time} ms")
    println("Main program ends on ${Thread.currentThread().name}")
}

suspend fun getMessageOne():String{
    delay(1000)  //pretend to do some work
    return "Hello"
}

suspend fun getMessageTwo():String{
    delay(1000)  //pretend to do some work
    return "World"
}