import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = br.readLine().split(" ").map {it.toInt()}
    val edge = Array(n+1) { ArrayList<Int>() }
    var ans = 0
    val visited = BooleanArray(n+1) { false }
    val queue = LinkedList<Int>()

    repeat(m){
        val (a, b) = br.readLine().split(" ").map {it.toInt()}
        edge[a].add(b)
        edge[b].add(a)
    }

    for(i in 1 .. n){
        if(!visited[i]){
            visited[i] = true
            queue.add(i)

            while(queue.isNotEmpty()){
                val s = queue.poll()
                for(j in edge[s]){
                    if(!visited[j]){
                        visited[j] = true
                        queue.add(j)
                    }
                }
            }
            ans++
        }
    }

    bw.write("$ans\n")
    bw.flush()
}

