import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while(true){
        val (x,y) = readln().split(" ").map {it.toInt()}
        if(x==y && x==0)
            break
        bw.write("${x+y}\n")
    }
    bw.flush()
}

