fun main() {
    val (x,y,z) = readln().split(" ").map {it.toInt()}

    println("${(x+y)%z}")
    println("${((x%z)+(y%z))%z}")
    println("${(x*y)%z}")
    println("${((x%z)*(y%z))%z}")
}
