import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = Array<Int>(42,{0})
    var cnt = 0
    for(i in 1..10) {
        val input = readln().toInt()
        arr[input%42] = 1
    }
    for(i in 0..41) {
        if(arr[i] == 1)
            cnt++
    }
    bw.write("$cnt\n")
    bw.flush()
}

