package kt.di.example

data class PutLimeInCoconutAction(val lime: Lime, val coconut: Coconut)

interface PutLimeInCoconutActionDispatcher : CoconutSplitSyntax {

    fun PutLimeInCoconutAction.perform(): HalfCoconut {
        val halves = coconut.split()

        val halfWithMilk = halves.first { it.milk != null }

        return halfWithMilk.putIn(lime)
    }

    private fun HalfCoconut.putIn(lime: Lime) = copy(milk = milk.mix(lime))

    private fun Milk?.mix(lime: Lime) = this?.copy(addedFlavor = lime.flavor)

}

