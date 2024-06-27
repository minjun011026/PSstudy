import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.pow

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = br.readLine().uppercase(Locale.getDefault())
    val alpha = Array<Int>(26, { 0 })

    for (i in 0..s.lastIndex) {
        alpha[s[i].code - 65]++
    }

    var max = 0
    var maxA = 0
    for (i in 0..25) {
        if (alpha[i] >= max) {
            max = alpha[i]
            maxA = i
        }
    }

    var cnt = 0
    for(i in 0..25){
        if(max==alpha[i]){
            cnt++
        }
    }

    if(cnt==1)
        bw.write("${(maxA+65).toChar()}\n")
    else
        bw.write("?\n")
    bw.flush()
}