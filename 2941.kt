import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Long.min
import java.util.*
import kotlin.math.pow

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = br.readLine()

    var cnt = s.length
    var i = 0
    while(i<s.lastIndex){

        val tmp:String = "${s[i]}${s[i+1]}"

        if(tmp == "c=" || tmp == "c-" || tmp == "d-" || tmp == "lj" || tmp == "dz" || tmp == "nj" || tmp == "s=" || tmp == "z="){
            if(tmp == "dz") {
                if (i + 2 <= s.lastIndex){
                    if(s[i+2] == '=') {
                        cnt -= 2
                        i+=2
                    }
                }
            }else{
                cnt-=1
                i++
            }
        }
        i++
    }

    bw.write("$cnt\n")
    bw.flush()
}