package kt.di.example

fun main(args: Array<String>) = with(commandDispatcher()) {
    when {
        args.isEmpty() -> MainCommand().perform()
        args.getOrNull(0) == "coconut" -> CoconutCommand(args[1]).perform()
    }
}

interface CommandDispatcher : MainCommandDispatcher, CoconutCommandDispatcher

private fun commandDispatcher(): CommandDispatcher = object : CommandDispatcher,
        CoconutStepDispatcher,
        RepositoryDirectory by repositoryDirectory(),
        ClientDirectory by clientDirectory() {
    override val actionDispatcher: CoconutStepDispatcher get() = this
}

private fun clientDirectory(): ClientDirectory = object : ClientDirectory {
    override val waiter: Waiter get() = SingletonWaiter
}

private fun repositoryDirectory(): RepositoryDirectory = object : RepositoryDirectory {
    override val coconutRepository: CoconutRepository get() = SingletonCoconutRepository
    override val limeRepository: LimeRepository get() = SingletonLimeRepository
}
