import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while(true){
        val input = readlnOrNull()
        if(input == null)
            break
        val (x,y) = input.split(" ").map {it.toInt()}
        bw.write("${x+y}\n")
    }
    bw.flush()
}

