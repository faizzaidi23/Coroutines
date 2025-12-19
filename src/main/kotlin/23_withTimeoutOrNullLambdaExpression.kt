import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main()= runBlocking {
    println("Main function starting on :${Thread.currentThread().name}")
    val result:String? = withTimeoutOrNull(2000){
        for( i in 0..100){
            println("$i.")
            delay(20)
        }
        "I am done" // this is a string either this will be returned or null will be returned
    }
    println("Result:$result")
    println("Main function ends here on :${Thread.currentThread().name}")

}