import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n= readln().toInt()
    val st = StringTokenizer(readln())
    val arr = ArrayList<Double>()
    var i = 0
    var max:Double = 0.0
    var sum:Double = 0.0
    while(st.hasMoreTokens()) {
        arr.add(st.nextToken().toDouble())
        if(arr[i]>max)
            max = arr[i]
        i++
    }
    for(i in 0..n-1) {
        arr[i] = (arr[i] / max) * 100
        sum+=arr[i]
    }
    bw.write("${sum/n}\n")
    bw.flush()
}

