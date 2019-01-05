package kt.di.example

interface RepositoryDirectory {
    val coconutRepository: CoconutRepository
    val limeRepository: LimeRepository
}

val repositoryDirectory = object : RepositoryDirectory {
    override val coconutRepository: CoconutRepository get() = SingletonCoconutRepository
    override val limeRepository: LimeRepository get() = SingletonLimeRepository
}

interface ClientDirectory {
    val waiter: Waiter
}

val clientDirectory = object : ClientDirectory {
    override val waiter: Waiter get() = SingletonWaiter
}

interface CommandDispatcher : MainCommandDispatcher, CoconutCommandDispatcher

val commandDispatcher: CommandDispatcher = object : CommandDispatcher,
        CoconutStepDispatcher,
        RepositoryDirectory by repositoryDirectory,
        ClientDirectory by clientDirectory {
    override val actionDispatcher: CoconutStepDispatcher get() = this
}

object SingletonLimeRepository : LimeRepository, EchoSyntax {
    override fun get() = Lime("Tart").also { echo("Got lime") }
}

object SingletonCoconutRepository : CoconutRepository, EchoSyntax {
    override fun get(id: String) = Coconut(id, "Smooth").also { echo("Got coconut with id ${it.id} for a dime") }
}

object SingletonCoconutSplitter : EchoSyntax {
    fun split(coconut: Coconut) = listOf(HalfCoconut(null), HalfCoconut(Milk(coconut.flavor, null)))
            .also { echo("Put the lime in the coconut") }
}

object SingletonWaiter : Waiter, EchoSyntax {
    override fun sendDrinkToCustomer(drink: Drink) = echo("Drank em bot up")
}

fun main(args: Array<String>) = commandDispatcher.run {

    when {
        args.isEmpty() -> MainCommand().perform()
        args.getOrNull(0) == "coconut" -> CoconutCommand(args[1]).perform()
    }

}