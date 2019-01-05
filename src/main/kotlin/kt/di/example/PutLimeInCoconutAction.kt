package kt.di.example

data class PutLimeInCoconutAction(val lime: Lime, val coconut: Coconut)

interface PutLimeInCoconutActionDispatcher : CoconutSplitSyntax {

    fun PutLimeInCoconutAction.perform() = coconut.split()
            .halfWithMilk()
            .putIn(lime)

    private fun List<HalfCoconut>.halfWithMilk() = mapNotNull { it.milk?.makeDrink() }.first()

    private fun Milk.makeDrink(): HalfCoconutDrink? = HalfCoconutDrink(this)

    private fun HalfCoconutDrink.putIn(lime: Lime) = copy(milk = milk.mix(lime))

    private fun Milk.mix(lime: Lime) = copy(addedFlavor = lime.flavor)

}

