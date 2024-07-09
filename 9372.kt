import java.io.*
import java.util.*

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t){
        val (n,m) = br.readLine().split(" ").map {it.toInt()}
        repeat(m){
            val (a,b) = br.readLine().split(" ").map {it.toInt()}
        }
        bw.write("${n-1}\n")
    }
    bw.flush()
}