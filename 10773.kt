import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val k = br.readLine().toInt()
    val s = Stack<Int>()
    var sum = 0
    repeat(k){
        val i = br.readLine().toInt()
        if(i == 0)
            sum -= s.pop()
        else {
            s.push(i)
            sum+=i
        }
    }

    bw.write("$sum\n")
    bw.flush()
}