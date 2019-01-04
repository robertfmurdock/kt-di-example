package kt.di.example

data class CoconutCommand(val id: String)

interface CoconutCommandDispatcher {

    val actionDispatcher: CoconutStepDispatcher

    private fun GetCoconutAction.perform() = with(actionDispatcher) { perform() }
    private fun GetLimeAction.perform() = with(actionDispatcher) { perform() }
    private fun PutLimeInCoconutAction.perform() = with(actionDispatcher) { perform() }
    private fun DrinkUpAction.perform() = with(actionDispatcher) { perform() }

    fun CoconutCommand.perform() = getIngredients()
            .putLimeInCoconut()
            .drinkItUp()

    private fun CoconutCommand.getIngredients() = Pair(getCoconut(), getLime())

    private fun HalfCoconutDrink.drinkItUp() = DrinkUpAction(this).perform()

    private fun Pair<Coconut, Lime>.putLimeInCoconut() = PutLimeInCoconutAction(second, first).perform()

    private fun getLime() = GetLimeAction.perform()

    private fun CoconutCommand.getCoconut() = GetCoconutAction(id).perform()

}

interface CoconutStepDispatcher :
        GetCoconutActionDispatcher,
        GetLimeActionDispatcher,
        PutLimeInCoconutActionDispatcher,
        DrinkUpActionDispatcher