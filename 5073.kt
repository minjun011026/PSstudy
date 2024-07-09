import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while(true){
        val (a,b,c) = br.readLine().split(' ').map {it.toInt()}

        val max = if(a>b) (if(a>c) a else c) else (if(b>c) b else c)
        val oth = a+b+c-max

        if (a == b && a == c && a == 0)
            break

        if(oth>max) {
            if (a == b && a == c)
                bw.write("Equilateral\n")
            else if (a == b || b == c || a == c)
                bw.write("Isosceles\n")
            else
                bw.write("Scalene\n")
        }else{
            bw.write("Invalid\n")
        }

    }
    bw.flush()
}