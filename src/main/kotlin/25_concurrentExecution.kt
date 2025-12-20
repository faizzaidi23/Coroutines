import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

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