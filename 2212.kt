fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    val gap = arr.zipWithNext { a, b -> b - a }.mapIndexed { idx, it -> it to idx }.sortedByDescending { it.first }
    val cut = Array(n) { false }
    var result = 0
    repeat(k-1) {
        if(it < n-1) cut[gap[it].second] = true
    }
    var before = arr[0]
    for(i in 0..<n) {
        if(cut[i]) {
            result += arr[i] - before
            if(i<n-1) before = arr[i+1]
        }
    }
    result += arr[n-1] - before
    println(result)
}
