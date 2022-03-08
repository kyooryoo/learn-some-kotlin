fun main() {
    println("Hello, class and random!!!")
    
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random number: $randomNumber\n")
    
    val myFirstDice = Dice(6, "blue")
    println("Your ${myFirstDice.sides} sided dice in ${myFirstDice.color} rolled ${myFirstDice.roll()}")
    val mySecondDice = Dice(20, "red")
    println("Your ${mySecondDice.sides} sided dice in ${mySecondDice.color} rolled ${mySecondDice.roll()}")
    
    val myCoin = Coin()
    val times = 10
    println("\nYou flip coin $times times")
    repeat(times) {
        println("${myCoin.flip()}")
    }
    
}

class Dice(val sides: Int, val color: String) {
    fun roll(): Int {
        return (1..sides).random()
    }
}

class Coin() {
    fun flip(): String {
 		return if ((0..1).random() == 0) "face" else "tail"
    }
}