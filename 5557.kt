fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val m = Array(n) { Array(21) { -1L } }
    fun dp(target: Int, idx : Int) : Long {
        if(idx == 0){
            return if(arr[idx] == target) 1
            else 0
        }
        if(target !in 0..20) return 0
        if(m[idx][target] != -1L) return m[idx][target]
        m[idx][target] = dp(target-arr[idx], idx-1) + dp(target+arr[idx], idx-1)
        return m[idx][target]
    }
    println("${dp(arr[n-1], n-2)}")
}
