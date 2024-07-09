import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var sum = 1
    for(i in 0..10000000){
        sum += 6*i
        if(n<=sum){
            bw.write("${i+1}\n")
            break
        }
    }
    bw.flush()
}