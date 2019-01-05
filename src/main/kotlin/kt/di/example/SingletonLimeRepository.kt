package kt.di.example

object SingletonLimeRepository : LimeRepository, EchoSyntax {
    override fun get() = Lime("Tart").also { echo("Got lime") }
}