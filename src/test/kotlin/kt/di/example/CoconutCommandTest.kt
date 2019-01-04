package kt.di.example

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.kotlintest.Description
import io.kotlintest.specs.FunSpec

class CoconutCommandTest : CoconutCommandDispatcher, FunSpec() {

    override lateinit var actionDispatcher: CoconutStepDispatcher

    override fun beforeTest(description: Description) {
        actionDispatcher = mock()
    }

    init {

        test("will do all the appropriate actions") {
            val coconutId = "The first one I saw."

            val expectedCoconut = Coconut(coconutId, "Rancid")
            val expectedLime = Lime("Strangely sweet")
            val expectedDrink = HalfCoconutDrink(Milk("Skim", "Hot sauce"))

            with(actionDispatcher) {
                whenever(GetCoconutAction(coconutId).perform())
                        .thenReturn(expectedCoconut)
                whenever(GetLimeAction.perform())
                        .thenReturn(expectedLime)
                whenever(PutLimeInCoconutAction(expectedLime, expectedCoconut).perform())
                        .thenReturn(expectedDrink)
            }

            CoconutCommand(coconutId)
                    .perform()

            with(verify(actionDispatcher)) { GetCoconutAction(coconutId).perform() }
            with(verify(actionDispatcher)) { GetLimeAction.perform() }
            with(verify(actionDispatcher)) { PutLimeInCoconutAction(expectedLime, expectedCoconut).perform() }
            with(verify(actionDispatcher)) { DrinkUpAction(expectedDrink).perform() }
        }
    }
}
