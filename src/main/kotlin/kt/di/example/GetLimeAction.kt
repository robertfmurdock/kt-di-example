package kt.di.example

object GetLimeAction

interface GetLimeActionDispatcher {

    val limeRepository: LimeRepository

    fun GetLimeAction.perform() = limeRepository.get()
}