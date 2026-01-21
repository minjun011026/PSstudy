import kotlin.math.min
import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr1 = readln().split(" ").map { it.toInt() }
    val arr2 = readln().split(" ").map { it.toInt() }
    val result = mutableMapOf<Int, Int>()
    var answer = Int.MAX_VALUE
    for(i in 0..<n) {
        if(arr1[i] >= m)
            answer = min(answer, arr2[i])
        else {
            for ((cost, memory) in result.toMap()) {
                if(m <= arr1[i] + memory)
                    answer = min(answer, cost + arr2[i])
                else
                    result[cost+arr2[i]] = max(memory + arr1[i], result.getOrDefault(cost+arr2[i],0))
            }
            result[arr2[i]] = max(arr1[i], result.getOrDefault(arr2[i],0))
        }
    }
    println(answer)
}
