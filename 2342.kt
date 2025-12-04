fun main() {
    val (n, m) = readln().split(" ").map {it.toInt()}
    val arr = readln().split(" ").map {it.toInt()}
    var s = 0
    var e = arr.sum()
    while(s<e) {
        val mid = (s+e) / 2
        var cnt = 0
        var tmp = 0
        var isEnough = true
        for(i in 0..<n) {
            if(tmp + arr[i] <= mid) tmp += arr[i]
            else {
                if(tmp != 0) {
                    cnt++
                    tmp = 0
                    if(arr[i] <= mid) tmp = arr[i]
                    else isEnough = false
                }
                else isEnough = false
            }
        }
        if(tmp != 0) cnt++
        if(isEnough) {
            if (cnt <= m) e = mid
            else s = mid + 1
        } else s = mid + 1
    }
    println(s)
}
