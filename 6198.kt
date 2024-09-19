import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var sum = 0L
    val pq = PriorityQueue<Int>()
    val buildings : Queue<Int> = LinkedList()
    repeat(n){
        buildings.add(br.readLine().toInt())
    }
    pq.add(buildings.poll())
    while(buildings.isNotEmpty()){
        val current = buildings.poll()
        while(pq.isNotEmpty() && pq.peek()<=current) {
            pq.poll()
        }
        sum += pq.size
        pq.add(current)
    }
    bw.write("$sum")
    bw.flush()
    bw.close()
}
