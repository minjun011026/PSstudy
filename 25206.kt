import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var sum:Double = 0.0
    var hak = 0.0
    repeat(20){
        val (s,h,g)= br.readLine().split(' ')
        var gs:Double = 0.0
        when (g) {
            "A+" -> gs = 4.5
            "A0" -> gs = 4.0
            "B+" -> gs = 3.5
            "B0" -> gs = 3.0
            "C+" -> gs = 2.5
            "C0" -> gs = 2.0
            "D+" -> gs = 1.5
            "D0" -> gs = 1.0
            "F" -> gs = 0.0
        }
        if(g != "P") {
            sum += h.toDouble() * gs
            hak+= h.toDouble()
        }
    }

    bw.write("${sum/hak}\n")

    bw.flush()
}