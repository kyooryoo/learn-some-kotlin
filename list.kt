fun main() {
    println("Hello, list!!!")
    
    //  unmutable list
    println("\nUnmutable list:")
    val numbers: List<Int> = listOf(1,2,3,4,5,6)
    val nums = listOf(6,5,4,3,2,1)
    println("List: $numbers")
    println("List: $nums")

    // access items in a list
    println("Size: ${numbers.size}")
    println("First element: ${numbers[0]}")
    println("First element: ${numbers.first()}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("Last element: ${numbers.last()}")

    // check if an item exists or not in a list
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")

    // sort or reverse the item order in a list
    println("Reversed: $numbers -> ${numbers.reversed()}")
    println("Sorted: $nums -> ${nums.sorted()}")
    
    //  change unmutable list will bring errors
    //  numbers.add(7)
    //  numbers[0] = 8
	
    //  mutable list
    println("\nMutable list:")
    val entrees = mutableListOf<String>()
    val entrees2: MutableList<String> = mutableListOf()
    println("Entrees: $entrees")
    
    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")
    
    val moreItems = listOf("ravioli","lasagna","fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")
    
    //  cannot add item with incorrect or different data type
    //  entrees.add(10)

	println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    
    //  remove some item does not exist
    println("Remove rice: ${entrees.remove("rice")}")
    println("Entrees: $entrees")
    
    println("Remove 1st item: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")
    
    println("Empty? ${entrees.isEmpty()}")
    entrees.clear()
    println("Entress: $entrees")
    println("Empty? ${entrees.isEmpty()}")
    
    //  while loop
	println("\nLoops:")
	var total = 0
    var index = 0
	while (index < numbers.size) {
        total += numbers[index]
        index++
    }
    println("Total by while: $total")
    
    // for loop
    total = 0
    for (number in numbers) {
        total += number
    }
    println("Total by for: $total")
    
    // 	other samples of for loop
	print("A list of chars: ")
	for (item in 'b'..'g') print(item)
    print("\nA list of numbers: ")
    for (item in 1..5) print(item)
    print("\nA list of numbers in reverse: ")
    for (item in 5 downTo 1) print(item)
    print("\nOdd numbers: ")
    for (item in 1..10 step 2) print(item)
    
    // 	a sample project
	println("\n\nA sample project:")
	val noodles = Noodles()
    val vegetables1 = Vegetables("Cabbage","Sprouts","Onion")
    val vegetables2 = Vegetables()
    println(noodles)
    println(vegetables1)
    println(vegetables2)
    
    val orderList = mutableListOf<Order>()
    
    //  add an item to an order
    val order1 = Order(1)
    order1.addItem(Noodles())
    orderList.add(order1)
    
    //  add mutiple items inddividually
    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    orderList.add(order2)
    
    //  add a list of items at one time
    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots","Beans","Celery"))
    order3.addAll(items)
    orderList.add(order3)
    
        //  use builder pattern
    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage","Onion"))
    orderList.add(order4)
    
    //  create and add order directly
    orderList.add(
    	Order(5)
    		.addItem(Noodles())
    		.addItem(Noodles())
            .addItem(Vegetables("Spinach")))
    
    //  print out each order
    for (order in orderList) {
        order.print()
    }
}

//  the base class for creating other classes
open class Item(val name: String, val price: Int)

// one child class with specified name and price
class Noodles : Item("Noodles", 10) {
    override fun toString(): String {
        return name
    }
}

// another child class with mutiple var args
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {
    override fun toString(): String {
        if (toppings.isEmpty()) {
            return "$name Chef's choice"
        } else {
            return name + " : " + toppings.joinToString()
        }
    }
}

// an order class with self-include index
class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()
        
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }
        
    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }
        
    fun print() {
        println("\nOrder #${orderNumber}")
        var total = 0
        for (item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}