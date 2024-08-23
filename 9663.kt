import java.io.*

var cnt = 0
lateinit var plus : BooleanArray
lateinit var minus : BooleanArray
lateinit var visited : BooleanArray

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    plus = BooleanArray(n*2)
    minus = BooleanArray(n*2)
    visited = BooleanArray(n)
    queens(0,n)
    bw.write("$cnt")
    bw.flush()
    bw.close()
}

fun queens(row : Int, n : Int) {
    if(row==n) {
        cnt++
        return
    }

    for(i in 0 ..< n){
        if(!chk(row,i, n)){
            visited[i] = true
            minus[n+row-i] = true
            plus[row+i] = true
            queens(row+1,n)
            visited[i] = false
            minus[n+row-i] = false
            plus[row+i] = false
        }
    }
}

fun chk(row : Int, i : Int, n : Int) = visited[i] || minus[n+row-i] || plus[row+i]
