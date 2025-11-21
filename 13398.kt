import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = Array(2) { Array(n) { 0 } }
    dp[0][0] = arr[0]
    dp[1][0] = arr[0]
    for(i in 1..<n) {
        dp[0][i] = max(dp[0][i-1] + arr[i], arr[i])
        dp[1][i] = max(dp[0][i-1], dp[1][i-1]+arr[i])
    }
    println("${max(dp[0].max(), dp[1].max())}")
}
