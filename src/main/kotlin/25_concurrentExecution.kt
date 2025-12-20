import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/*
Here the async coroutine builder will launch a coroutine on the main thread too
since the parent coroutine is the runBlocking and the async is the child coroutine
it will be running on the main thread
They will be returning the object of Deferred<String>--->Here deferred means the result we will be getting lately
but since the suspend functions have delay in them
when delay() will be encountered then the coroutine will be suspended and the second coroutine will get hold of the main thread
and then the delay() is encountered on the second suspending function then the main thread is free
and after 1 second when the delay of both the suspending functions is completed then it will be doing to the returning


*******The main thing here is we do not know which coroutine will get the coroutine after the resuming of the coroutine

*/
fun main()=runBlocking{

    println("Main function starts on the ${Thread.currentThread().name}")

    val time= measureTimeMillis {
        val msgOne: Deferred<String> = async{getMsgOne()}
        val msgTwo: Deferred<String> = async{getMsgTwo()}

        println("The entire message printed is:${msgOne.await()+msgTwo.await()}")
    }
    println("Completed in time:${time} ms")
    println("Main function ends on :${Thread.currentThread().name}")

}

suspend fun getMsgOne():String{
    delay(1000)
    return "Hello There"
}

suspend fun getMsgTwo():String{
    delay(1000)
    return "This is the second suspending function "
}