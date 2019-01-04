package kt.di.example

data class CoconutCommand(val id: String)

interface CoconutCommandDispatcher {

    val actionDispatcher: CoconutStepDispatcher

    private fun GetCoconutAction.perform() = with(actionDispatcher) { perform() }
    private fun GetLimeAction.perform() = with(actionDispatcher) { perform() }
    private fun PutLimeInCoconutAction.perform() = with(actionDispatcher) { perform() }
    private fun DrinkUpAction.perform() = with(actionDispatcher) { perform() }

    fun CoconutCommand.perform() {
        val coconut = GetCoconutAction(id).perform()
        val lime = GetLimeAction.perform()
        val drink = PutLimeInCoconutAction(lime, coconut).perform()
        DrinkUpAction(drink).perform()
    }

}

interface CoconutStepDispatcher :
        GetCoconutActionDispatcher,
        GetLimeActionDispatcher,
        PutLimeInCoconutActionDispatcher,
        DrinkUpActionDispatcher