import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    while(true){
        val s = br.readLine()
        var scnt = 0
        var bcnt = 0
        if(s==".")
            break

        val st = Stack<Char>()
        for(i in 0..s.lastIndex){
            if(s[i]=='.') {
                if(scnt == 0 && bcnt == 0)
                    bw.write("yes\n")
                else
                    bw.write("no\n")
            }
            if(s[i] == '(') {
                st.push('s')
                scnt++
            }else if(s[i] == ')') {
                if(st.size == 0){
                    bw.write("no\n")
                    break
                }
                if (st.pop() != 's') {
                    bw.write("no\n")
                    break
                }
                scnt--
            }else if(s[i] == '[') {
                st.push('b')
                bcnt++
            }else if(s[i] == ']') {
                if(st.size == 0){
                    bw.write("no\n")
                    break
                }
                if (st.pop() != 'b') {
                    bw.write("no\n")
                    break
                }
                bcnt--
            }
        }
    }
    bw.flush()
}