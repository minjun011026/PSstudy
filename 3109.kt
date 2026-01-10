fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    val arr = Array(R) { Array(C) { '.' } }
    var cnt = 0
    repeat(R) {
        val input = readln().map { it }
        arr[it] = input.toTypedArray()
    }

    fun gd(a: Int, b: Int): Boolean {
        arr[a][b] = 'X'
        if (b == C - 1) {
            cnt++
            return true
        }
        var result = false
        if (a > 0 && arr[a - 1][b + 1] == '.') result = gd(a - 1, b + 1)
        if(!result && arr[a][b + 1] == '.') result = gd(a, b + 1)
        if(!result && a < R - 1 && arr[a + 1][b + 1] == '.') result = gd(a + 1, b + 1)
        return result
    }
    for (i in 0..<R) {
        gd(i,0)
    }
    println(cnt)
}
