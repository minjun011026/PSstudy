fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val arr = ArrayList<Int>()
    repeat(n) {
        arr.add(readln().toInt())
    }
    arr.sort()
    var s = 0
    var e = arr[n-1] - arr[0] + 1
    while(s+1<e) {
        val m = (s+e) / 2
        var before = arr[0]
        var cnt = 1
        for(i in 1..<n) {
            if(arr[i] >= before+m) {
                before = arr[i]
                cnt++
            }
        }
        if(cnt>=c) s = m
        else e = m
    }
    println(s)
}
