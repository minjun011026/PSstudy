import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var pos = 0
    var max = 0
    for(i in 1..9){
        val temp = readln().toInt()
        if(temp>=max){
            max = temp
            pos = i
        }
    }
    bw.write("$max\n$pos\n")
    bw.flush()
}

