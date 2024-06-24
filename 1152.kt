import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(readln())
    var cnt = 0
    while(st.hasMoreTokens()){
        st.nextToken()
        cnt++
    }
    bw.write("$cnt\n")
    bw.flush()
}

