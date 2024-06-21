fun main() {
    val (x, y) = readln().split(" ").map {it.toInt()}

    println("${x+y}")
    println("${x-y}")
    println("${x*y}")
    println("${x/y}")
    println("${x%y}")

}