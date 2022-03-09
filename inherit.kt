import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    
    // use *with* for removing duplicated instance name 
    with(squareCabin) {
        println("\nSquare Cabin\n===============")
    	println("Capacity: ${capacity}")
    	println("Material: ${buildingMaterial}")
    	println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }
    
    with(roundHut) {
        println("\nRound Hut\n===============")
    	println("Capacity: ${capacity}")
    	println("Material: ${buildingMaterial}")
    	println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Size: %.2f".format(calculateMaxCarpetSize()))
    }
    
    // getRoom function is inherited from parent root class
    println("\nLet's try getting a room in Round Hut:")
    println("Has room? ${roundHut.hasRoom()}")
    roundHut.getRoom()
    println("Has room? ${roundHut.hasRoom()}")
    roundHut.getRoom()
    
    with(roundTower) {
        println("\nRound Tower\n===============")
    	println("Capacity: ${capacity}")
    	println("Material: ${buildingMaterial}")
    	println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet Size: %.2f".format(calculateMaxCarpetSize()))
    }
}

// root abstract class for creating child class
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    fun hasRoom(): Boolean {
        return residents < capacity
    }
    
    fun getRoom() {
        if(capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no room left!")
        }
    }
    
    abstract fun floorArea(): Double
}

// use *:* for indicating parent class
// inherited attributes do not need *val* keyword
class SquareCabin(
    residents: Int, 
    val length: Double): Dwelling(residents) {
    // use *override* keyword for overriding attributes
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double {
        return length * length
    }
}

// use open keyword for creating sub-child class
open class RoundHut(
    residents: Int,
	val radius: Double): Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

// add extra attribute with default value
class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2): RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
        override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}