import kotlin.math.max

fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { 0 to 0 }
    var max = 0
    val dp = Array(n+1) { Array(t+1) { 0 } }
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        max += b
        arr[it] = a to b
    }
    for(i in 1..n) {
        val (day, cost) = arr[i-1]
        for(j in 1..t) if(j >= day) dp[i][j] = max(dp[i-1][j], dp[i-1][j-day] + cost) else dp[i][j] = dp[i-1][j]
    }
    println(max-dp[n][t])
}
