import java.io.*

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val fibonacci = Array<Int>(1001, {1})
    val n = br.readLine().toInt()
    if(n>=2) {
        for (i in 2..n){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2])%10007
        }
    }
    bw.write("${fibonacci[n]}")
    bw.flush()
}

