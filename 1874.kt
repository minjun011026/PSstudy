import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = Stack<Int>()
    val n = br.readLine().toInt()
    var output = ArrayList<Char>()
    s.push(0)
    var now = 1
    repeat(n){
        val input = br.readLine().toInt()
        if(s.peek()<input){
            while(s.peek() != input){
                output.add('+')
                s.push(now)
                now++
            }
        }

        val pop = s.pop()
        if(pop != input) {
            println("NO\n")
            return
        }
        output.add('-')
    }
    println(output.joinToString("\n"))
}