import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val q = ArrayDeque<Int>()

    for(i in 1..n)
        q.add(i)

    while(q.size != 1){
        q.removeFirst()
        q.add(q.removeFirst())
    }
    bw.write("${q.removeFirst()}\n")
    bw.flush()
}