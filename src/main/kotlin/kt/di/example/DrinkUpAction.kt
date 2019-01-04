package kt.di.example

data class DrinkUpAction(val drink: Drink)

interface DrinkUpActionDispatcher {

    val waiter: Waiter


    fun DrinkUpAction.perform() {

    }
}