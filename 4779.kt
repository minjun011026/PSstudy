import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

fun Cantor(n:Int, s:ArrayList<Char>){
    if(n==0) {
        s.add('-')
        return
    }
    Cantor(n / 3, s)
    repeat(n){
        s.add(' ')
    }
    Cantor(n / 3, s)
}

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while(true){
        val n = readlnOrNull() ?: break

        val len = 3.toDouble().pow(n.toInt()).toInt()
        val s = ArrayList<Char>()
        Cantor(len/3, s)
        bw.write(s.joinToString("")+"\n")
    }

    bw.flush()
}
