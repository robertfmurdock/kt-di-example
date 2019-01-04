package kt.di.example

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.kotlintest.Description
import io.kotlintest.specs.FunSpec

class DrinkUpActionTest : DrinkUpActionDispatcher, FunSpec() {

    override lateinit var waiter: Waiter

    override fun beforeTest(description: Description) {
        waiter = mock()
    }

    init {
        test("perform will use the waiter to send the drink to be drunk") {
            val halfCoconutDrink = HalfCoconutDrink(Milk("stale", "extra sour"))

            DrinkUpAction(halfCoconutDrink).perform()

            verify(waiter).sendDrinkToCustomer(halfCoconutDrink)
        }
    }

}