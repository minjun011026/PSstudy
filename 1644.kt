import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val isPrime = BooleanArray(4000001) { true }
    isPrime[0] = false
    isPrime[1] = false
    var i = 2
    while (i * i <= 4000000) {
        if (isPrime[i]) {
            for (j in i * i..4000000 step i) {
                isPrime[j] = false
            }
        }
        i++
    }
    val N = br.readLine().toInt()
    var e = 2
    val arr = ArrayList<Int>()
    var sum = 0
    var cnt = 0
    while(true){
        if(sum < N){
            if(e > N) break
            if(isPrime[e]){
                sum += e
                arr.add(e)
            }
            e++
        }else if(sum == N){
            cnt++
            sum -= arr.removeFirst()
        }else sum -= arr.removeFirst()
    }

    bw.write("$cnt")

    bw.flush()
    bw.close()
}

