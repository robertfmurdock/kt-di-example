package kt.di.example

data class PutLimeInCoconutAction(val lime: Lime, val coconut: Coconut)

interface PutLimeInCoconutActionDispatcher : CoconutSplitSyntax {

    fun PutLimeInCoconutAction.perform() = coconut.split()
            .halfWithMilk()
            .putIn(lime)

    private fun List<HalfCoconut>.halfWithMilk() = first { it.milk != null }

    private fun HalfCoconut.putIn(lime: Lime) = copy(milk = milk.mix(lime))

    private fun Milk?.mix(lime: Lime) = this?.copy(addedFlavor = lime.flavor)

}

