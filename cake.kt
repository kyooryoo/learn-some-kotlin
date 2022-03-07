fun main() {
    val age = 26
    val name = "Ling"
    print("Happy Birthday! ")
    println("${name}")
    println("You are ${age} old!")
    
    val layers = 5
    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)
 }
 
 fun printCakeCandles(age: Int) {
     print(" ")
     repeat(age) {
         print(",")
     }
     println()
     
     print(" ")
     repeat(age) {
         print("|")
     }
     println()
 }
 
 fun printCakeTop(age: Int) {
     repeat(age+2) {
         print("=")
     }
     println()
 }
 
 fun printCakeBottom(age: Int, layers: Int) {
     repeat(layers) {
         repeat(age+2) {
             print("@")
         }
         println()
     }
 }