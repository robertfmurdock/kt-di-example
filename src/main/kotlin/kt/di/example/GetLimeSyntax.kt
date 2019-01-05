package kt.di.example

interface GetLimeSyntax {

    val limeRepository: LimeRepository

    fun getLime() = limeRepository.get()

}