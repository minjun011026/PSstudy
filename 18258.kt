import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val q = ArrayDeque<Int>()

    repeat(n){
        val st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens()){
            val cmd = st.nextToken()
            if(cmd == "push"){
                q.add(st.nextToken().toInt())
            }else if(cmd == "pop"){
                if(q.size == 0)
                    bw.write("-1\n")
                else
                    bw.write("${q.removeFirst()}\n")
            }else if(cmd == "size")
                bw.write("${q.size}\n")
            else if(cmd == "empty"){
                if(q.size == 0)
                    bw.write("1\n")
                else
                    bw.write("0\n")
            }else if(cmd == "front"){
                if(q.size == 0)
                    bw.write("-1\n")
                else
                    bw.write("${q.first()}\n")
            }else if(cmd == "back"){
                if(q.size == 0)
                    bw.write("-1\n")
                else
                    bw.write("${q.last()}\n")
            }
        }
    }
    bw.flush()
}