package kt.di.example

data class GetCoconutAction(val id: String)

interface GetCoconutActionDispatcher {

    val coconutRepository: CoconutRepository

    fun GetCoconutAction.perform(): Coconut {
        return coconutRepository.get(id)
    }
}