fun main() {
    val (n, k) = readln().split(" ").map {it.toInt()}
    var i = 1
    var answer = 0
    while(true) {
        if(n<=i) break
        i *= 2
    }
    if(n / i == 0) {
        while(true) {
            var cnt = 0
            var cur = n + answer
            var j = i
            while(true) {
                cnt += cur / j
                cur = cur % j
                j /= 2
                if(j == 0) break
            }
            if(cnt <= k) break
            answer++
        }
        println(answer)
    } else {
        println("0")
    }
}
