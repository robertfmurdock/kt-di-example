package kt.di.example

data class CoconutCommand(val id: String)

interface CoconutCommandDispatcher {

    val actionDispatcher: CoconutStepDispatcher

    fun CoconutCommand.perform() {
    }

}

interface CoconutStepDispatcher :
        GetCoconutActionDispatcher,
        GetLimeActionDispatcher,
        PutLimeInCoconutActionDispatcher,
        DrinkUpActionDispatcher