import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = readln()
    val alphabet = Array<Int>(26,{-1})
    for(i in 0..input.length-1){
        if(alphabet[input[i].code-97] == -1)
            alphabet[input[i].code-97] = i
    }
    bw.write("${alphabet.joinToString(" ")}\n")

    bw.flush()
}

