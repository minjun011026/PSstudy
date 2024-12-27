import java.io.*
import kotlin.math.max

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    val b = br.readLine()
    val arr = Array(a.length+1) {Array(b.length+1) {0} }
    for(i in a.indices){
        for(j in b.indices){
            if(a[i]==b[j])
                arr[i+1][j+1] = arr[i][j]+1
            else
                arr[i+1][j+1] = max(arr[i+1][j], arr[i][j+1])
        }
    }
    bw.write("${arr[a.length][b.length]}")
    bw.flush()
    bw.close()
}


