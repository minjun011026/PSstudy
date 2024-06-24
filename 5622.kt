import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = readln()
    var num = 0
    var sum = 0
    for(i in 0..s.length-1){
        if(s[i].code<68)
            num = 2
        else if(s[i].code<71)
            num = 3
        else if(s[i].code<74)
            num = 4
        else if(s[i].code<77)
            num = 5
        else if(s[i].code<80)
            num = 6
        else if(s[i].code<84)
            num = 7
        else if(s[i].code<87)
            num = 8
        else
            num = 9
        sum += num + 1
    }
    bw.write("$sum\n")
    bw.flush()
}

