import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val m = br.readLine().toInt()
    val s = ArrayList<Int>()

    repeat(m){
        val cmd = br.readLine().split(' ')
        if(cmd[0] == "add")
            s.add(cmd[1].toInt())
        else if(cmd[0] == "remove")
            s.remove(cmd[1].toInt())
        else if(cmd[0] == "check"){
            if(s.contains(cmd[1].toInt()))
                bw.write("1\n")
            else
                bw.write("0\n")
        }else if(cmd[0] == "toggle"){
            if(s.contains(cmd[1].toInt()))
                s.remove(cmd[1].toInt())
            else
                s.add(cmd[1].toInt())
        }else if(cmd[0] == "all") {
            s.clear()
            for(i in 1..20)
                s.add(i)
        }else if(cmd[0] == "empty")
            s.clear()
    }

    bw.flush()
}