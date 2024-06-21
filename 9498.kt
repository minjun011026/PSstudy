fun main() {
    val input = readln().toInt()

    if(input>=90)
        println("A")
    else if(input>=80)
        println("B")
    else if(input>=70)
        println("C")
    else if(input>=60)
        println("D")
    else
        println("F")
}
