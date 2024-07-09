import java.io.*
import java.util.*
import kotlin.math.absoluteValue

lateinit var s:List<Int>

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val ox= charArrayOf('O', 'X')

    while(true){
        val s = br.readLine()
        var xcnt = 0
        var ocnt = 0

        var isEnd = false

        if(s=="end")
            break

        for(i in 0..8){
            if(s[i] == 'X')
                xcnt++
            else if(s[i] == 'O')
                ocnt++
        }

        for(i in 0..1){
            if(((s[0] == s[1] && s[1] == s[2]) && s[0] == ox[i]) || ((s[3] == s[4] && s[4] == s[5]) && s[3] == ox[i]) || ((s[6] == s[7] && s[7] == s[8]) && s[6] == ox[i]) || ((s[0] ==s[3] &&s[3] ==s[6]) && s[0] == ox[i]) || ((s[1] == s[4] && s[4] == s[7]) && s[1] == ox[i]) || ((s[2] == s[5] &&s[5] ==s[8]) && s[2] == ox[i]) ||((s[0] ==s[4] &&s[4] ==s[8]) && s[0] == ox[i]) || ((s[2] == s[4] && s[4] == s[6]) && s[2] == ox[i])){
                if (ox[i] == 'O') {
                    if (ocnt!=xcnt) {
                        isEnd = false
                        break
                    }
                    isEnd = true
                } else if (ox[i] == 'X') {
                    if (isEnd) {
                        isEnd = false
                        break
                    }
                    isEnd = true
                    if(ocnt +1 != xcnt) {
                        isEnd = false
                        break
                    }
                }
            }else if(ocnt == 4 && xcnt == 5 && i ==1) {
                if (isEnd) {
                    isEnd = false
                    break
                }
                isEnd = true
            }
        }

        if(!(ocnt == xcnt || xcnt-1 == ocnt))
            isEnd = false

        if(isEnd)
            bw.write("valid\n")
        else
            bw.write("invalid\n")
    }


    bw.flush()
}