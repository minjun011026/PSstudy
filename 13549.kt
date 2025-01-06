import java.io.*
import java.util.PriorityQueue

const val MAX = 100000000
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val distance = Array(100001) { MAX }
    pq.add(Pair(start, 0))
    distance[start] = 0
    while (pq.isNotEmpty()) {
        val (position, weight) = pq.poll()
        if (position * 2 <= 100000 && weight < distance[position*2]) {
            distance[position*2] = weight
            pq.add(Pair(position * 2, weight))
        }
        if (position + 1 <= 100000 && weight+1 < distance[position+1]) {
            distance[position+1] = weight+1
            pq.add(Pair(position + 1, weight + 1))
        }
        if (position - 1 >= 0 && weight+1 < distance[position-1]) {
            distance[position-1] = weight+1
            pq.add(Pair(position - 1, weight + 1))
        }
    }
    bw.write("${distance[end]}")
    bw.flush()
    bw.close()
}
