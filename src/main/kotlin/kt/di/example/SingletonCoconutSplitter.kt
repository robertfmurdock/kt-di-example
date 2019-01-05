package kt.di.example

object SingletonCoconutSplitter : EchoSyntax {
    fun split(coconut: Coconut) = listOf(HalfCoconut(null), HalfCoconut(Milk(coconut.flavor, null)))
            .also { echo("Put the lime in the coconut") }
}