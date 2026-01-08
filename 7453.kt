import java.io.*
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(br.readLine())
    if (!st.hasMoreTokens()) return
    val n = st.nextToken().toInt()
    val aArr = IntArray(n)
    val bArr = IntArray(n)
    val cArr = IntArray(n)
    val dArr = IntArray(n)
    val sum1 = IntArray(n*n) { 0 }
    val sum2 = IntArray(n*n) { 0 }
    var result = 0L
    repeat(n) { i ->
        val line = StringTokenizer(br.readLine())
        aArr[i] = line.nextToken().toInt()
        bArr[i] = line.nextToken().toInt()
        cArr[i] = line.nextToken().toInt()
        dArr[i] = line.nextToken().toInt()
    }

    for(i in 0..<n) {
        val a = aArr[i]
        val c = cArr[i]
        for(j in 0..<n) {
            sum1[n*i + j] = a + bArr[j]
            sum2[n*i + j] = c + dArr[j]
        }
    }
    sum1.sort()
    sum2.sort()

    var s = 0
    var e = n*n - 1
    while(s < n*n && e >= 0) {
        val sum = sum1[s] + sum2[e]
        if(sum == 0) {
            val l = sum1[s]
            val r = sum2[e]
            var c1 = 0L
            var c2 = 0L
            while(s < n*n && sum1[s] == l) {
                s++
                c1++
            }
            while(e >= 0 && sum2[e] == r) {
                e--
                c2++
            }
            result += c1 * c2
        }else if(sum < 0) s++
        else e--
    }
    bw.write("$result")
    bw.flush()
    bw.close()
}
