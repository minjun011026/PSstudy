import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()

    repeat(t){
        val (n,m) = br.readLine().split(' ').map {it.toInt()}
        val q = ArrayDeque<Int>()
        val st = StringTokenizer(br.readLine())

        var cnt = 0
        var pos = m
        var l = 0

        while(st.hasMoreTokens())
            q.add(st.nextToken().toInt())

        for(i in 9 downTo 1){
            while(l<q.size){
                if(q[0] == i) {
                    cnt++
                    q[0] = 0
                    l = 0
                    if(pos == 0) {
                        bw.write("$cnt\n")
                        break
                    }
                }
                q.add(q.removeFirst())
                pos--
                if(pos<0)
                    pos = q.size-1
                l++
            }
            l=0
        }

    }

    bw.flush()
}