import java.io.*
import kotlin.math.min

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, S) = br.readLine().split(" ").map {it.toInt()}
    val arr =  ArrayList<Int>()
    arr.addAll(br.readLine().split(" ").map{it.toInt()})
    var i = 0
    var j = 0
    var minLength = N+1
    var sum = arr[i]
    while(j<N){
        if(sum >= S){
            minLength = min(minLength, j-i+1)
            if(sum - arr[i] >= S) {
                sum -= arr[i]
                i++
            }
            else {
                j++
                if(j>=N) break
                sum += arr[j]
            }
        }else {
            j++
            if(j>=N) break
            sum += arr[j]
        }
    }
    if(minLength == N+1) minLength = 0
    bw.write("$minLength")
    bw.flush()
    bw.close()
}
