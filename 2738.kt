import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(' ').map {it.toInt()}
    val arr = Array(N,{ArrayList<Int>()})


    for(i in 0..<N){
        val st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens())
            arr[i].add(st.nextToken().toInt())
    }

    for(i in 0..<N){
        val st = StringTokenizer(br.readLine())
        for(j in 0..<M){
            arr[i][j]+=st.nextToken().toInt()
        }
    }

    for(i in 0..<N)
        bw.write(arr[i].joinToString(" ")+"\n")



    bw.flush()
}