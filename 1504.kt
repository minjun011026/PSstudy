import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    val (n, e) = readln().split(" ").map { it.toInt() }
    val edge = Array(n + 1) { Array(n + 1) { -1 } }
    repeat(e) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        edge[a][b] = c
        edge[b][a] = c
    }
    val (v1,v2) = readln().split(" ").map { it.toInt() }
    var isPossible = true
    fun dijkstra(cur: Int, target: Int): Int {
        val q = PriorityQueue<Int>()
        val visit = Array(n + 1) { false }
        val d = Array(n+1) { Int.MAX_VALUE }
        q.add(cur)
        d[cur] = 0
        while(q.isNotEmpty()) {
            val cur = q.poll()
            visit[cur] = true
            for(i in 1..n) {
                if(edge[cur][i] < 0) continue
                val cost = d[cur] + edge[cur][i]
                if(cost < d[i]) {
                    d[i] = cost
                    q.add(i)
                }
            }
        }
        if(!visit[target]) isPossible = false
        return d[target]
    }

    val t1 = dijkstra(1,v1)
    val t2 = dijkstra(1,v2)
    val v1Tov2 = dijkstra(v1,v2)
    val v2Tov1 = dijkstra(v2,v1)
    val v1Ton = dijkstra(v1,n)
    val v2Ton = dijkstra(v2,n)
    if(isPossible) println(min(t1+v1Tov2+v2Ton, t2+v2Tov1+v1Ton))
    else println("-1")
}
