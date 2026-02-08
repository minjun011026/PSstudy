fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val coin = readln().split(" ").map { it.toInt() }
        val m = readln().toInt()
        val dp = Array(m+1) { 0 }
        for(i in 0..<n) {
            dp[coin[i]] += 1
            for(j in coin[i] + 1..m) dp[j] += dp[j - coin[i]]
        }
        println(dp[m])
    }
}
