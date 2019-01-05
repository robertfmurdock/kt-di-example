package kt.di.example

interface StringGetCoconutSyntax {

    val coconutRepository: CoconutRepository

    fun String.getCoconut() = coconutRepository.get(this)

}