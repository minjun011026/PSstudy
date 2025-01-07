import java.io.*
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val v = br.readLine().toInt()
    val lines = Array(v+1) { ArrayList<Pair<Int,Int>>() }
    var farIndex = 1
    repeat(v){
        val input = br.readLine().split(" ").map {it.toInt()}
        for(i in 1..<input.lastIndex step(2)){
            lines[input[0]].add(Pair(input[i],input[i+1]))
        }
    }
    fun bfs(idx : Int) : Long{
        val q : Queue<Pair<Int,Long>> = LinkedList()
        val visited = Array(v+1) { false }
        var maxDistance = 0L
        visited[idx] = true
        q.add(Pair(idx,0))
        while(q.isNotEmpty()){
            val (next, weight) = q.poll()
            if(weight > maxDistance){
                maxDistance = weight
                farIndex = next
            }
            for(i in lines[next]){
                if(!visited[i.first]){
                    visited[i.first] = true
                    q.add(Pair(i.first, i.second+weight))
                }
            }
        }
        return maxDistance
    }

    bfs(1)
    bw.write("${bfs(farIndex)}")
    bw.flush()
    bw.close()
}
