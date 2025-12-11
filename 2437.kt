fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted()
    if (arr[0] > 1) println(1)
    else {
        var max = arr[0]
        for(i in 1..<n) {
            if(max+1 < arr[i]) break
            else max += arr[i]
        }
        println(max+1)
    }
}
