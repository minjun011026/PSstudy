import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = ArrayList<Int>()
    arr.addAll(br.readLine().split(" ").map {it.toInt()})
    var i = 0L
    var j = 0L
    val isIn = Array (100001) { false }
    var sum = 0L
    while(j < N){
        if(i==j) {
            isIn[arr[j.toInt()]] = true
            j++
        }
        else {
            if (!isIn[arr[j.toInt()]]) {
                isIn[arr[j.toInt()]] = true
                j++
            } else {
                sum += j - i
                isIn[arr[i.toInt()]] = false
                i++
            }
        }
    }
    sum += (j-i)*(j-i+1)/2
    bw.write("$sum")
    bw.flush()
    bw.close()
}

