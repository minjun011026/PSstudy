fun main() {
    val (x, y) = readln().split(" ").map {it.toInt()}
    val z = readln().toInt()

    if((x+(y+z)/60)>=24)
        println("${(x+(y+z)/60)-24} ${(y+z)%60}")
    else
        println("${x+(y+z)/60} ${(y+z)%60}")
}
