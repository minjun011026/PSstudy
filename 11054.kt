import java.io.*
import kotlin.math.max

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val up = Array(n) { 1 }
    val down = Array(n) { 1 }

    for(i in 1..<n){
        for(j in 0..<i){
            if(arr[i]>arr[j]) up[i] = max(up[i], up[j]+1)
        }
    }

    for(i in n-2 downTo 0){
        for(j in n-1 downTo i+1){
            if(arr[i]>arr[j]) down[i] = max(down[i], down[j]+1)
        }
    }
    
    bw.write("${(0..<n).maxOf { up[it] + down[it] - 1 }}")
    bw.flush()
    bw.close()
}
