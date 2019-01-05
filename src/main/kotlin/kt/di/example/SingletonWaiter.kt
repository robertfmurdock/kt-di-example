package kt.di.example

object SingletonWaiter : Waiter, EchoSyntax {
    override fun sendDrinkToCustomer(drink: Drink) = echo("Drank em bot up")
}