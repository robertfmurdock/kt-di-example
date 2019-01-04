package kt.di.example

class GetLimeAction

interface GetLimeActionDispatcher {

    val limeRepository: LimeRepository

    fun GetLimeAction.perform() = limeRepository.get()
}