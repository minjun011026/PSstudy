import kotlin.math.min

fun main() {
    val n = readln().toLong()
    val k = readln().toInt()
    var s = 0L
    var e = n*n
    while(s<e) {
        val m = (s+e) / 2
        var c = 0L
        for(i in 1..n) c += min(n, m/i)
        if(c >= k) e = m
        else s = m + 1
    }
    println(s)
}
