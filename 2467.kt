import java.io.*
import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    s = br.readLine().split(" ").map {it.toInt()}

    var min = 2000000000
    var minIndex1 = 0
    var minIndex2 = 0
    for(i in 0..<n){
        val num = s[i] * -1
        val temp = binarySearch(num,0,n-1)
        if((s[i] + s[temp]).absoluteValue < min && i!=temp) {
            min = (s[i] + s[temp]).absoluteValue
            minIndex1 = i
            minIndex2 = temp
        }
    }
    if(s[minIndex1] < s[minIndex2])
        bw.write("${s[minIndex1]} ${s[minIndex2]}\n")
    else
        bw.write("${s[minIndex2]} ${s[minIndex1]}\n")

    bw.flush()
}

fun binarySearch(num : Int, start :Int, end:Int) : Int{
    val m = (start+end)/2
    if(start +1 ==  end){
        return if((num-s[start]).absoluteValue < (num-s[end]).absoluteValue) start else end
    }

    return if(num<s[m]){
        binarySearch(num,start,m)
    }else{
        binarySearch(num,m,end)
    }
}


