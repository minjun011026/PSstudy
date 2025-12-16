import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    var cnt = 0
    val q = PriorityQueue<Long>()
    q.addAll(0..9L)
    while(true) {
        val num = q.poll()
        val maximum = num % 10
        for(i in 0..<maximum) q.add(num * 10 + i)
        if(cnt == n) {
            println(num)
            break
        }
        cnt++
        if(q.isEmpty()) {
            println(-1)
            break
        }
    }
}
