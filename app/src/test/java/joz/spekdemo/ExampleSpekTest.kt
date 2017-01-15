package joz.spekdemo

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.Assert.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class ExampleSpekTest : Spek({
    val x = 2
    val y = 3

    given("x = $x and y = $y") {
        val sum = x + y

        it("should be that x + y = 5") {
            assertEquals(5, sum)
        }

        it("should be that x - y = -1") {
            val subtract = x - y
            assertEquals(-1, subtract)
        }

    }
})