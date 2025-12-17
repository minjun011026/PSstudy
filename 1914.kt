fun main() {
    val n = readln().toInt()
    println("${2L.toBigInteger().pow(n).minus(1L.toBigInteger())}")
    if(n <= 20) {
        fun hanoi(num: Int, s: Int, e: Int, mid: Int) {
            if(num != 1) hanoi(num-1, s, mid, e)
            println("$s $e")
            if(num != 1) hanoi(num-1,mid, e, s)
        }
        hanoi(n, 1,3, 2)
    }
}
