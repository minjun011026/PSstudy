import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t){
        val k = br.readLine().toInt()
        val pq = TreeMap<Int ,Int> {c1, c2 -> c1.compareTo(c2)}
        repeat(k){
            val (cmd, num) = br.readLine().split(" ")
            when(cmd){
                "D"-> {
                    if(pq.isNotEmpty()) {
                        if (num.toInt() == -1) {
                            if(pq[pq.firstKey()] == 1)
                                pq.remove(pq.firstKey())
                            else
                                pq[pq.firstKey()] = pq[pq.firstKey()]!! - 1
                        } else {
                            if(pq[pq.lastKey()] == 1)
                                pq.remove(pq.lastKey())
                            else
                                pq[pq.lastKey()] = pq[pq.lastKey()]!! - 1
                        }
                    }
                }
                "I" -> {
                    pq[num.toInt()] = pq.getOrDefault(num.toInt(), 0) + 1
                }
            }
        }
        if(pq.isEmpty()) bw.write("EMPTY\n")
        else {
            bw.write("${pq.lastKey()} ${pq.firstKey()}\n")
        }
    }
    bw.flush()
    bw.close()
}
