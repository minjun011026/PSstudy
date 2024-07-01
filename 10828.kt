import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val s = Stack<Int>()
    repeat(n){
        val st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens()){
            val c = st.nextToken()
            if(c == "push")
                s.push(st.nextToken().toInt())
            else if(c == "pop"){
                if(s.size==0)
                    bw.write("-1\n")
                else
                    bw.write("${s.pop()}\n")
            }
            else if(c == "top"){
                if(s.size==0)
                    bw.write("-1\n")
                else
                    bw.write("${s.peek()}\n")
            }
            else if(c == "size")
                bw.write("${s.size}\n")
            else if(c == "empty"){
                if(s.size == 0)
                    bw.write("1\n")
                else
                    bw.write("0\n")
            }
        }
    }
    bw.flush()
}