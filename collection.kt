fun main() {
	// list is a collection with order and nonunique items
	val numbers = listOf(8, 2, 0, 3, 7, 3, 9, 2, 0)
    println("A list: $numbers")
    println("Sorted: ${numbers.sorted()}")
    
    // convert a list to a set
    val toSet = numbers.toSet()
    println("toSet: $toSet")
    
    // create sets and compare them
    val set1 = setOf(1,2,2,3)
    val set2 = mutableSetOf(3,3,2,1)
    println("${set1} == $set2? ${set1 == set2}")
    
    // check if contains or not
    println("Contains 7? ${toSet.contains(7)}")
    
    // a simple map
    val peopleAges = mutableMapOf<String, Int> (
        "Fred" to 30,
        "Ann" to 23
    )
    println(peopleAges)
    
    // add item to map
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
    
    // loop through a map
    for (people in peopleAges) {
        print("${people.key} is ${people.value}, ")
    }
    println()
    // another shortway with forEach and it
    peopleAges.forEach { print("${it.key} is ${it.value}, ")}
    println()
    // with map
    println(peopleAges.map {"${it.key} is ${it.value}"}.joinToString(", "))
    
    // filter
    val firstNames = peopleAges.filter { it.key.length < 4}
    println(firstNames)
    
    // define lambda function like define a variable
    val num: Int = 5
    val triple: (Int) -> Int = { x: Int -> x * 3} 
    // use the default shortway it, if only one param
    val double: (Int) -> Int = { it * 2}
    println("Tiple of $num: ${triple(num)}")
    println("Double of $num: ${double(num)}")
    
    // sort with specified conditions
    val peopleNames = peopleAges.keys
    println(peopleNames.sorted())
    println(peopleNames.sortedWith{
        str1: String, str2: String -> str1.length - str2.length})
    
    // filter, random order, pick out, and sort
	val words = listOf("about", "acute", "awesome", "balloon", 
                       "best", "brief", "class", "coffee", "creative")
    val filteredWords = words.filter { it.startsWith("b", ignoreCase=true) }
        .shuffled().take(2).sorted()
    println(filteredWords)
}