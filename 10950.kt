fun main() {
    val n = readln().toInt()

    for(i in 1..n){
        val (x, y) = readln().split(" ").map {it.toInt()}
        println("${x+y}")
    }

}
