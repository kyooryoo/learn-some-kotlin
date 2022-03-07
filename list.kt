fun main() {
    println("Hello, list!!!")
    
//     unmutable list
    println("\nUnmutable list:")
    val numbers: List<Int> = listOf(1,2,3,4,5,6)
    val nums = listOf(6,5,4,3,2,1)
    println("List: $numbers")
    println("List: $nums")
    println("Size: ${numbers.size}")
    println("First element: ${numbers[0]}")
    println("First element: ${numbers.first()}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("Last element: ${numbers.last()}")
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")
    println("Reversed: $numbers -> ${numbers.reversed()}")
    println("Sorted: $nums -> ${nums.sorted()}")
    
//     cannot change unmutable list
//     numbers.add(7)
//     numbers[0] = 8
	
//     mutable list
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
    
//     cannot add item with incorrect or different type
//     entrees.add(10)

	println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    
//     remove some item does not exist
    println("Remove rice: ${entrees.remove("rice")}")
    println("Entrees: $entrees")
    
    println("Remove 1st item: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")
    
    println("Empty? ${entrees.isEmpty()}")
    entrees.clear()
    println("Entress: $entrees")
    println("Empty? ${entrees.isEmpty()}")

//     while loop
	println("\nLoops:")
	var total = 0
    var index = 0
	while (index < numbers.size) {
        total += numbers[index]
        index++
    }
    println("Total by while: $total")
    
    total = 0
    for (number in numbers) {
        total += number
    }
    println("Total by for: $total")
    
//     other samples of for loop
	print("A list of chars: ")
	for (item in 'b'..'g') print(item)
    print("\nA list of numbers: ")
    for (item in 1..5) print(item)
    print("\nA list of numbers in reverse: ")
    for (item in 5 downTo 1) print(item)
    print("\nOdd numbers: ")
    for (item in 1..10 step 2) print(item)

//     while loop
	println("\nLoops:")
	var total = 0
    var index = 0
	while (index < numbers.size) {
        total += numbers[index]
        index++
    }
    println("Total by while: $total")
    
    total = 0
    for (number in numbers) {
        total += number
    }
    println("Total by for: $total")
    
//     other samples of for loop
	print("A list of chars: ")
	for (item in 'b'..'g') print(item)
    print("\nA list of numbers: ")
    for (item in 1..5) print(item)
    print("\nA list of numbers in reverse: ")
    for (item in 5 downTo 1) print(item)
    print("\nOdd numbers: ")
    for (item in 1..10 step 2) print(item)
}