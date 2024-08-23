import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n, x, y) = br.readLine().split(" ").map { it.toInt() }
        var min = 0
        var minRemain = 0
        var max = 0
        var maxRemain = 0
        if(m>n){
            max = m
            maxRemain = x
            min = n
            minRemain = y
        }else{
            max = n
            min = m
            maxRemain = y
            minRemain = x
        }
        var result = -1
        var i = 0
        var j = 0
        while (i <= max) {
            if (min * i + minRemain == max*j+maxRemain) {
                result = min * i + minRemain
                break
            }else if(min * i + minRemain > max*j+maxRemain) j++
            else i++
        }

        bw.write("$result\n")
    }
    bw.flush()
    bw.close()
}
