import java.io.*
import kotlin.math.max


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, K) = br.readLine().split(" ").map {it.toInt()}
    val items = ArrayList<Pair<Int,Int>>(N)
    val napSack = Array(N+1) {Array(K+1) { 0 } }
    repeat(N){
        val (weight, value) = br.readLine().split(" ").map {it.toInt()}
        items.add(Pair(weight, value))
    }
    items.sortBy { it.first }
    for(i in 1..N){
        for(j in 0..K){
            if(items[i-1].first > j)
                napSack[i][j] = napSack[i-1][j]
            else
                napSack[i][j] = max(items[i-1].second + napSack[i-1][j-items[i-1].first], napSack[i-1][j])
        }
    }
    bw.write("${napSack[N][K]}")
    bw.flush()
    bw.close()
}


