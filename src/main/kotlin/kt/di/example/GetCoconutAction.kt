package kt.di.example

data class GetCoconutAction(val id: String)

interface GetCoconutActionDispatcher : StringGetCoconutSyntax {

    fun GetCoconutAction.perform() = id.getCoconut()
}
