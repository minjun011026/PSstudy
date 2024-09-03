import java.io.*
import java.util.PriorityQueue

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()
    var sum = 0
    repeat(n){
        pq.add(br.readLine().toInt())
    }
    if(n!=1) {
        while (true) {
            val a = pq.poll()
            val b = pq.poll()
            sum += a + b
            if (pq.isEmpty())
                break
            pq.add(a + b)
        }
    }
    bw.write("$sum")
    bw.flush()
    bw.close()
}
