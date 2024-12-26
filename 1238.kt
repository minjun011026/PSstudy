import java.io.*
import java.util.PriorityQueue

const val MAX = 1000000000

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,M,X) = br.readLine().split(" ").map {it.toInt()}
    val graph = Array(N+1) { ArrayList<Pair<Int,Int>>() }
    val reverseGraph = Array(N+1) { ArrayList<Pair<Int,Int>>() }
    repeat(M){
        val (start, end, weight) = br.readLine().split(" ").map {it.toInt()}
        graph[start].add(Pair(end,weight))
        reverseGraph[end].add(Pair(start,weight))
    }

    fun dijkstra(start : Int, graph : Array<ArrayList<Pair<Int, Int>>>) : Array<Int>{
        val distance  = Array(N+1) {MAX}
        val q = PriorityQueue<Pair<Int,Int>>(compareBy { item -> item.second })
        distance[start] = 0
        q.add(Pair(start, 0))
        while (q.isNotEmpty()) {
            val (node, dist) = q.poll()
            if (dist > distance[node]) continue
            for ((next, weight) in graph[node]) {
                if (distance[next] > distance[node] + weight) {
                    distance[next] = distance[node] + weight
                    q.add(Pair(next, distance[next]))
                }
            }
        }
        return distance
    }

    val go = dijkstra(X, graph)
    val back = dijkstra(X, reverseGraph)

    val maxDistance = (1..N).maxOf { go[it] + back[it] }
    bw.write("$maxDistance")
    bw.flush()
    bw.close()
}


