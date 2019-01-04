package kt.di.example

interface CoconutSplitSyntax {
    fun Coconut.split() = listOf(HalfCoconut(null), HalfCoconut(Milk(flavor, null)))
}
