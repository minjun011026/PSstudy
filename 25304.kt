fun main() {
    val recipe = readln().toInt()
    val n = readln().toInt()
    var sum:Int = 0
    for(i in 1..n){
        val (x, y) = readln().split(" ").map {it.toInt()}
        sum += (x*y)
    }

    if(recipe == sum)
        println("Yes")
    else
        println("No")

}
