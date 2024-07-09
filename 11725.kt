import java.io.*
import java.util.*

lateinit var parents:IntArray

class Graph(val n:Int){
    val adjList :MutableList<MutableList<Int>> = MutableList(n) { mutableListOf() }

    fun addEdge(v1: Int, v2:Int){
        adjList[v1].add(v2)
    }

    fun BFS(root : Int){
        val visited = BooleanArray(n) {false}
        val queue = LinkedList<Int>()

        visited[root] = true
        queue.add(root)

        while(queue.isNotEmpty()){
            val s = queue.poll()
            for(i in adjList[s]){
                if(!visited[i]){
                    visited[i] = true
                    queue.add(i)
                    parents[i] = s
                }
            }
        }
    }

}

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    parents = IntArray(n+1)
    val graph = Graph(n+1)

    repeat(n-1){
        val (a,b) = br.readLine().split(" ").map {it.toInt()}
        graph.addEdge(a,b)
        graph.addEdge(b,a)
    }

    graph.BFS(1)

    for(i in 2..n){
        bw.write("${parents[i]}\n")
    }

    bw.flush()
}