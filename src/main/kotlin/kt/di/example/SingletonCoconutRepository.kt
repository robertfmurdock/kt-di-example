package kt.di.example

object SingletonCoconutRepository : CoconutRepository, EchoSyntax {
    override fun get(id: String) = Coconut(id, "Smooth").also { echo("Got coconut with id ${it.id} for a dime") }
}