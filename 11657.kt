fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val arr = ArrayList<Triple<Int,Int,Int>>()
    val result = Array(N+1) { Long.MAX_VALUE }
    var isCycle = false
    repeat(M) {
        val (a,b,c) = readln().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    result[1] = 0
    repeat(N+1) { i ->
        repeat(M) { j ->
            val (a,b,c) = arr[j]
            if(result[a] != Long.MAX_VALUE && result[a] + c < result[b]) {
                result[b] = result[a] + c
                if(i == N) isCycle = true
            }
        }
    }
    if(isCycle) println("-1")
    else {
        for(i in 2..N) {
            println(if (result[i] == Long.MAX_VALUE) -1 else result[i])
        }
    }
}
