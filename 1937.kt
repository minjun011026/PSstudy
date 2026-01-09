import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { Array(n) { 0 } }
    val cnt = Array(n) { Array(n) { 0 } }
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, -1, 0, 1)
    repeat(n) {
        arr[it] = readln().split(" ").map { it.toInt() }.toTypedArray()
    }

    fun dp(i: Int, j: Int): Int {
        if (cnt[i][j] != 0) return cnt[i][j]
        var tmp = 1
        for (k in 0..3) {
            if (i + dx[k] in 0..<n && j + dy[k] in 0..<n && arr[i][j] < arr[i + dx[k]][j + dy[k]]) tmp = max(dp(i + dx[k], j + dy[k])+1,tmp)
        }
        cnt[i][j] = tmp 
        return tmp
    }

    for (i in 0..<n) {
        for (j in 0..<n) {
            dp(i, j)
        }
    }

    var max = 0
    for (i in 0..<n) {
        for (j in 0..<n) {
            if (cnt[i][j] > max) max = cnt[i][j]
        }
    }
    
    println(max)
}
