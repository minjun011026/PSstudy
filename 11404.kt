import java.io.*
import kotlin.math.min

const val MAX = 1000000000

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array(n) { Array(n) { MAX } }
    val m = br.readLine().toInt()
    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        arr[a - 1][b - 1] = min(c, arr[a-1][b-1])
    }
    repeat(n) {
        arr[it][it] = 0
    }

    for (i in 0..<n) {
        for (j in 0..<n) {
            for (k in 0..<n) {
                arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k])
            }
        }
    }

    for (j in 0..<n) {
        for (k in 0..<n) {
            if(arr[j][k]==MAX) arr[j][k] = 0
        }
    }
    bw.write(arr.joinToString("\n") { it.joinToString(" ") })
    bw.flush()
    bw.close()
}
