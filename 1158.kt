import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n,k) = br.readLine().split(' ').map {it.toInt()}
    val q = ArrayDeque<Int>()
    val o = ArrayList<Int>()
    var cnt = 0
    var i = -1
    for(i in 1..n)
        q.add(i)

    while(cnt!=q.size){
        repeat(k){
            i++
            if(i == q.size)
                i = 0
            if(q[i] == 0){
                while(q[i]==0) {
                    i++
                    if(i == q.size)
                        i = 0
                }
            }
        }

        o.add(q[i])
        q[i] = 0
        cnt++
    }
    bw.write("<"+o.joinToString(", ")+">")
    bw.flush()
}