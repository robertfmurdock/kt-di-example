package kt.di.example

import java.io.PrintStream

interface EchoSyntax {

    val outputStream: PrintStream get() = System.out

    fun echo(value: String) = outputStream.println(value)
}
