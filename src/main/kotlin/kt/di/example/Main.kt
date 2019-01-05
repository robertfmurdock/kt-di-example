package kt.di.example

val repositoryDirectory = object : RepositoryDirectory {
    override val coconutRepository: CoconutRepository get() = SingletonCoconutRepository
    override val limeRepository: LimeRepository get() = SingletonLimeRepository
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

fun main(args: Array<String>) = commandDispatcher.run {

    when {
        args.isEmpty() -> MainCommand().perform()
        args.getOrNull(0) == "coconut" -> CoconutCommand(args[1]).perform()
    }

}