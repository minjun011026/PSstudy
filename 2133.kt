fun main() {
    val s = readln().toInt()
    val arr = Array(31) { 0 }
    arr[0] = 1
    if(s%2 == 1) println("0")
    else {
        fun d(idx: Int) : Int {
            if(arr[idx] != 0) return arr[idx]
            var tmp = 0
            for(i in 2..idx step(2)) {
                tmp += d(idx-i)
            }
            tmp *= 2
            tmp += d(idx-2)
            arr[idx] = tmp
            return arr[idx]
        }
        println("${d(s)}")
    }
}
