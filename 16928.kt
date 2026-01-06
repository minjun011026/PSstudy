import java.util.*

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val ls = mutableMapOf<Int,Int>()
    val q : Queue<Pair<Int,Int>> = LinkedList()
    val arr = Array(101) { Int.MAX_VALUE }
    repeat(N) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        ls[a] = b
    }
    repeat(M) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        ls[a] = b
    }
    q.add(1 to 0)
    while(q.isNotEmpty()) {
        val (num, cnt) = q.poll()
        if(arr[num] <= cnt) continue
        arr[num] = cnt
        if(ls.containsKey(num)) q.add(ls[num]!! to cnt)
        else {
            for (i in 1..6) {
                if(num+i <= 100) q.add(num + i to cnt + 1)
            }
        }
    }
    println(arr[100])
}
