fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val fibonacci = Array(41) { 0 }
    val vip = mutableSetOf<Int>()
    var result = 1
    fibonacci[0] = 1
    fibonacci[1] = 1
    fibonacci[2] = 2
    fun getfib(i : Int) : Int {
        if(fibonacci[i] != 0) return fibonacci[i]
        fibonacci[i] = getfib(i-1) + getfib(i-2)
        return fibonacci[i]
    }

    repeat(m) {
        vip.add(readln().toInt() - 1)
    }
    var cursor = 0
    for(i in 0..<n) {
        if(i in vip) {
            result *= getfib(i-cursor)
            cursor = i+1
        }
    }
    result*=getfib(n-cursor)
    println("$result")
}
