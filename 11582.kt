import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var sortedArr: ArrayList<Int>

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val cs = ArrayList<Int>()
    var r = 2


    while(st.hasMoreTokens()){
        cs.add(st.nextToken().toInt())
    }

    sortedArr = ArrayList(cs)

    val k = br.readLine().toInt()

    while(n!=k){
        for(i in 0..cs.lastIndex step(r)){
            merge(cs,i,(i+i+r-1)/2,i+r-1)
        }
        n /= 2
        r *= 2
    }
    bw.write(cs.joinToString(" "))
    bw.flush()
}

fun merge(arr: ArrayList<Int>, start : Int, mid : Int, end : Int){
    var (i, j, k) = intArrayOf(start, mid+1, start)
    while (i <= mid && j <= end) {
        if (arr[i] <= arr[j]) {
            sortedArr[k] = arr[i]
            i++
        } else {
            sortedArr[k] = arr[j]
            j++
        }
        k++
    }
    if (i > mid) {
        for (t in j..end) {
            sortedArr[k] = arr[t]
            k++
        }
    } else {
        for (t in i..mid) {
            sortedArr[k] = arr[t]
            k++
        }
    }

    for (t in start..end) arr[t] = sortedArr[t]
}
