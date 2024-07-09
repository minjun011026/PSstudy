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

    val n = br.readLine().toInt()
    val tower = br.readLine().split(" ").map {it.toInt()}
    val s = Stack<Int>()

    s.push(0)
    bw.write("0 ")

    for(i in 1..<n){
        if(tower[s.peek()]>tower[i]){
            bw.write("${s.peek()+1}")
            s.push(i)
        }else{
            while(!s.isEmpty()){
                val index = s.pop()
                if(tower[index]>tower[i]){
                    s.push(index)
                    s.push(i)
                    bw.write("${index+1}")
                    break
                }
            }

            if(s.isEmpty()) {
                s.push(i)
                bw.write("0")
            }
        }
        if(i!=n-1) bw.write(" ")
    }

    bw.flush()
}