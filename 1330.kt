fun main() {
    val (x,y) = readln().split(" ").map {it.toInt()}
    if(x>y)
        println(">")
    else if(x<y)
        println("<")
    else
        println("==")
}
