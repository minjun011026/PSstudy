import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }.sorted()
    var min = Long.MAX_VALUE
    var answer = listOf<Long>()
    for(i in 0..n-3) {
        for(j in i+1 .. n-2) {
            val sum = (arr[i] + arr[j]) * -1
            var s = j+1
            var e = n-1
            while(s+1<e) {
                val m = (s+e) / 2
                if(arr[m] < sum) s = m
                else if(arr[m] > sum) e = m
                else {
                    s = m
                    e = m
                    break
                }
            }
            val mid = if(abs(arr[i]+arr[j]+arr[s]) < abs(arr[i]+arr[j]+arr[e])) s else e
            if(abs(arr[i]+arr[j]+arr[mid]) < min) {
                min = abs(arr[i]+arr[j]+arr[mid])
                answer = listOf(arr[i],arr[j],arr[mid])
            }
        }
    }
    println(answer.joinToString(" "))
}
