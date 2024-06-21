fun main() {
    val (x, y) = readln().split(" ").map {it.toInt()}

    if(y>=45)
        println("$x ${y-45}")
    else {
        if (x == 0)
            println("23 ${y+15}")
        else
            println("${x-1} ${y+15}")
    }
}
