package kt.di.example

class GetLimeAction

interface GetLimeActionDispatcher {

    val limeRepository: LimeRepository

    fun GetLimeAction.perform(): Lime {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}