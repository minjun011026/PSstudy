import java.io.*
import java.util.PriorityQueue

const val MAX = 200000000

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val distance = Array(N+1) { MAX }
    val bus = Array(N+1) { ArrayList<Pair<Int,Int>>() }
    val visited = Array(N+1) {false}
    val q = PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
    repeat(M){
        val (start, end, weight) = br.readLine().split(" ").map {it.toInt()}
        bus[start].add(Pair(end, weight))
    }
    val (start,end) = br.readLine().split(" ").map {it.toInt()}
    q.addAll(bus[start])
    distance[start] = 0
    visited[start] = true
    while(q.isNotEmpty()){
        val (to, weight) = q.poll()
        if(!visited[to]){
            distance[to] = weight
            visited[to] = true
            for(i in bus[to]){
                q.add(Pair(i.first, i.second+weight))
            }
        }
    }
    bw.write("${distance[end]}")
    bw.flush()
    bw.close()
}
