import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = Array<Int>(31,{0})
    for(i in 1..28) {
        val input = readln().toInt()
        arr[input] = 1
    }
    for(i in 1..30) {
        if(arr[i] == 0)
            bw.write("$i\n")
    }
    bw.flush()
}

