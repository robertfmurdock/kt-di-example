package kt.di.example

import io.kotlintest.Description
import io.kotlintest.specs.FunSpec
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainCommandDispatcherTest : MainCommandDispatcher, FunSpec() {

    override lateinit var outputStream: PrintStream
    private lateinit var byteArrayOutputStream: ByteArrayOutputStream

    override fun beforeTest(description: Description) {
        byteArrayOutputStream = ByteArrayOutputStream()
        outputStream = PrintStream(byteArrayOutputStream)
    }

    private val output get() = byteArrayOutputStream.toString("UTF-8").lines()

    init {
        test("main command will return help with no args") {

            MainCommand().perform()

            assertThat(output).containsOnly("Help!", "")
        }
    }

}