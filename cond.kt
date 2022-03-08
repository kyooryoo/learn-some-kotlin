fun main() {
    val diceRange = 1..6
    val randomNumber = diceRange.random()
    println("Random Number: ${randomNumber}")
    
    val luckyNumber = 4
     
    if (randomNumber == luckyNumber) {
        println("You win!")
    } else if (randomNumber == 1) {
        println("You rolled 1, didn't win. Try again!")
    } else {
        println("You didn't win. Try again!")
    }
    
    when (randomNumber) {
        luckyNumber -> println("You won!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        else -> println("Apologies! You didn't win. Try again!")
    }
    
    val myFirstDice = Dice(6)
    println("\nYour ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}")
    val mySecondDice = Dice(20)
    println("\nYour ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}")
 }
 
 class Dice(val numSides: Int) {
     fun roll(): Int {
         return (1..numSides).random()
     }
 }