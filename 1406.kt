import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val left = Stack<Char>()
    val right = Stack<Char>()
    left.addAll(br.readLine().toList())
    val n = br.readLine().toInt()
    repeat(n){
        val cmd = br.readLine()
        when(cmd[0]){
            'P'->left.add(cmd[2])
            'L'-> if(left.isNotEmpty())right.add(left.pop())
            'D'-> if(right.isNotEmpty())left.add(right.pop())
            'B'-> if(left.isNotEmpty())left.pop()
        }
    }
    bw.write(left.joinToString(""))
    bw.write(right.reversed().joinToString(""))
    bw.flush()
    bw.close()
}
