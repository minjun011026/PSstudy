import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val edges = Array(n + 1) { mutableSetOf<Pair<Int, Int>>() }
    repeat(m) {
        val (s, e, c) = readln().split(" ").map { it.toInt() }
        edges[s].add(e to c)
    }
    val (s, e) = readln().split(" ").map { it.toInt() }
    val dijkstra = Array(n+1) { "" to -1 }
    dijkstra[s] = "$s " to 0
    val q = PriorityQueue<Triple<String, Int, Int>>(compareBy { it.third })
    for((a,b) in edges[s]) {
        q.add(Triple("$s ", a, b))
    }
    while(q.isNotEmpty()) {
        val (route, pos, cost) = q.poll()
        if(dijkstra[pos].second == -1) {
            dijkstra[pos] = "$route$pos " to cost
            for((a,b) in edges[pos]) {
                q.add(Triple("$route$pos ", a, cost + b))
            }
        }
    }
    println(dijkstra[e].second)
    println(dijkstra[e].first.trim().split(" ").map { it.toInt() }.size)
    println(dijkstra[e].first)
}
