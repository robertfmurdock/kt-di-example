package kt.di.example

class MainCommand

interface MainCommandDispatcher : EchoSyntax {

    fun MainCommand.perform() {
        echo("Help!")
    }

}
