package kt.di.example

import io.kotlintest.specs.FunSpec
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainIntegrationTest : FunSpec({

    test("given no arguments, will return help") {
        val output = captureOutput { main(arrayOf()) }

        assertThat(output).containsExactly("Help!", "")
    }

    test("given coconut, will perform all steps") {
        val output = captureOutput { main(arrayOf("coconut", "3")) }

        assertThat(output).containsExactly(
                "Got coconut with id 3 for a dime",
                "Got lime",
                "Put the lime in the coconut",
                "Drank em bot up",
                "")
    }

})

private fun String?.assert() = assertThat(this)

private fun captureOutput(work: () -> Unit): List<String>? {
    val byteArrayOutputStream = ByteArrayOutputStream()
    val out = System.out
    try {
        System.setOut(PrintStream(byteArrayOutputStream))
        work()
    } finally {
        System.setOut(out)
    }
    return byteArrayOutputStream.toString("UTF-8")?.lines()
}