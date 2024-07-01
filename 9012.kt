import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    var cnt = 0
    repeat(t){
        val tc = br.readLine()
        cnt = 0
        for(i in 0..tc.lastIndex){
            if(tc[i] == '(')
                cnt++
            else if(tc[i] ==')') {
                cnt--
                if(cnt < 0)
                    break
            }
        }
        if(cnt == 0)
            bw.write("YES\n")
        else
            bw.write("NO\n")
    }


    bw.flush()
}