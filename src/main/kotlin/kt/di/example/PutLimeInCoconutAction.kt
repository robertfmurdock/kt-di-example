package kt.di.example

data class PutLimeInCoconutAction(val lime: Lime, val coconut: Coconut)

interface PutLimeInCoconutActionDispatcher {

    fun PutLimeInCoconutAction.perform(): HalfCoconut {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}