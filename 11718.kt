import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while(true){
        val s = readlnOrNull()
        if(s==null)
            break
        bw.write("$s\n")
    }
    bw.flush()
}

