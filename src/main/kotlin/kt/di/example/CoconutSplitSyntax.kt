package kt.di.example

interface CoconutSplitSyntax {

    val splitter get() = SingletonCoconutSplitter

    fun Coconut.split() = splitter.split(this)
}
