import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(readln())
    val chess = ArrayList<Int>()
    while(st.hasMoreTokens()){
        chess.add(st.nextToken().toInt())
    }
    chess[0] = 1 - chess[0]
    chess[1] = 1 - chess[1]
    chess[2] = 2 - chess[2]
    chess[3] = 2 - chess[3]
    chess[4] = 2 - chess[4]
    chess[5] = 8 - chess[5]
    bw.write(chess.joinToString(" "))

    bw.flush()
}
