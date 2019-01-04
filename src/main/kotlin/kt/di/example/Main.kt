package kt.di.example

val commandDispatcher = object : MainCommandDispatcher {
}

fun main(args: Array<String>) = commandDispatcher.run {
    MainCommand().perform()
}