package kt.di.example

interface MainCommand : EchoSyntax {

    fun execute() {
        echo("Help!")
    }

}