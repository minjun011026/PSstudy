import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (h,w,n,m) = br.readLine().split(' ').map {it.toInt()}


    var cnt = 0
    for(i in 0..<h step(n+1)){
        for(j in 0..<w step(m+1)){
            if(j<w)
                cnt++
        }
    }

    bw.write("$cnt\n")
    bw.flush()
}