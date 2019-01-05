package kt.di.example

interface DrinkSendToCustomerSyntax {

    val waiter: Waiter

    fun Drink.sendToCustomer() = waiter.sendDrinkToCustomer(this)

}