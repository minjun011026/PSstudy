fun main() {
    val (x,y) = readln().split(" ").map {it.toBigInteger()}


    println("${(x+y)*(x-y)}")

}
