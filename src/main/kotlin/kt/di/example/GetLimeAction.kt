package kt.di.example

object GetLimeAction

interface GetLimeActionDispatcher : GetLimeSyntax {

    fun GetLimeAction.perform() = getLime()

}
