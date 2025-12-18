package org.example

import kotlinx.coroutines.runBlocking
import org.example.CoroutineBuilders.myOwnSuspendingFunction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class SimpleTest{
    @Test
    fun myFirstTest()= runBlocking{
        myOwnSuspendingFunction()
        assertEquals(10,5+5)
    }

}