package kt.di.example

data class DrinkUpAction(val drink: Drink)

interface DrinkUpActionDispatcher : DrinkSendToCustomerSyntax {

    fun DrinkUpAction.perform() = drink.sendToCustomer()

}
