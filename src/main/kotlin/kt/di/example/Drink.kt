package kt.di.example

sealed class Drink

data class HalfCoconutDrink(val milk: Milk) : Drink()
