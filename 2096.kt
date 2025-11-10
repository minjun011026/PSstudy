import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var maxPost = Array(3) { 0 }
    val maxCur = Array(3) { 0 }
    var minPost = Array(3) { 0 }
    val minCur = Array(3) { 0 }
    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        maxCur[0] = input[0] + max(maxPost[0], maxPost[1])
        maxCur[1] = input[1] + max(max(maxPost[0], maxPost[1]), maxPost[2])
        maxCur[2] = input[2] + max(maxPost[1], maxPost[2])
        minCur[0] = input[0] + min(minPost[0], minPost[1])
        minCur[1] = input[1] + min(min(minPost[0], minPost[1]), minPost[2])
        minCur[2] = input[2] + min(minPost[1], minPost[2])
        maxPost = maxCur.copyOf()
        minPost = minCur.copyOf()
    }
    println("${maxCur.max()} ${minCur.min()}")
}
