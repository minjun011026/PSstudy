import java.io.*
import java.util.PriorityQueue

const val MAX = 1000000000
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val start = br.readLine().toInt()
    val arr = Array(v+1) { ArrayList<Pair<Int,Int>>() }
    val visited = Array(v+1) {false}
    val q = PriorityQueue<Pair<Int,Int>>(compareBy { it.second } )
    val distance = Array(v+1) {MAX}
    repeat(e){
        val (U, V, W) = br.readLine().split(" ").map {it.toInt()}
        arr[U].add(Pair(V,W))
    }
    visited[start] = true
    visited[0] = true
    distance[start] = 0
    q.addAll(arr[start])
    while(q.isNotEmpty()){
        while(true){
            val (node, weight) = q.poll()
            if(!visited[node]) {
                visited[node] = true
                distance[node] = weight
                q.addAll(arr[node].map {Pair(it.first, it.second+weight) }.filter { !visited[it.first] })
                break
            }
            if(q.isEmpty()) break
        }
    }
    bw.write(distance.drop(1).joinToString("\n") { if(it == MAX) "INF" else "$it"} )
    bw.flush()
    bw.close()
}

