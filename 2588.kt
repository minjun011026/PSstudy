fun main() {
    val x = readln().toInt()
    val y = readln().toInt()

    println("${(y%10)*x}")
    println("${((y/10)%10)*x}")
    println("${(y/100)*x}")
    println("${y*x}")

}
