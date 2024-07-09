import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

lateinit var e : Array<ArrayList<Node>>
lateinit var p : IntArray

data class Node(
    val num : Int,
    val dis : Int
)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n,m) = br.readLine().split(" ").map {it.toInt()}

    e  = Array(n+1) {ArrayList()}
    p = IntArray(n+1){100000000}

    repeat(m){
        val (f, t, d) = br.readLine().split(" ").map {it.toInt()}
        e[f].add(Node(t,d))
        e[t].add(Node(f,d))
    }

    bw.write("${dikjstra(n)}")
    bw.flush()
}

fun dikjstra(n:Int) : Int{
    val q = PriorityQueue<Node>{a,b -> a.dis - b.dis}
    q.add(Node(1,0))
    p[1] = 0
    while(q.isNotEmpty()){
        val (cn, cd) = q.poll()
        if(p[cn] < cd) continue
        if(cn == n) return cd
        for((nn, nd) in e[cn]){
            if (cd + nd >= p[nn]) continue
            p[nn] = cd + nd
            q.add(Node(nn, cd + nd))
        }
    }
    return -1
}

