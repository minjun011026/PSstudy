fun main() {
    val t = readln().toInt()
    val n = readln().toInt()
    val arr1 = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val arr2 = readln().split(" ").map { it.toInt() }
    val m1 = mutableMapOf<Int, Long>()
    val m2 = mutableMapOf<Int, Long>()
    var result = 0L
    for (i in 0..<n) {
        var tmp = 0
        for (j in i..<n) {
            tmp += arr1[j]
            m1[tmp] = m1.getOrDefault(tmp, 0) + 1
        }
    }
    for (i in 0..<m) {
        var tmp = 0
        for (j in i..<m) {
            tmp += arr2[j]
            m2[tmp] = m2.getOrDefault(tmp, 0) + 1
        }
    }
    for((a,b) in m1) {
        if(m2.containsKey(t-a)) result += b * m2[t-a]!!
    }
    println(result)
}
