import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var m = 0
var z = 0
var o = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val p = ArrayList<ArrayList<Int>>()

    repeat(n){
        p.add(ArrayList<Int>())
    }

    for(i in 0..<n){
        val st = StringTokenizer(br.readLine())
        for(j in 0..<n){
            while(st.hasMoreTokens()) {
                p[i].add(st.nextToken().toInt())
            }
        }
    }

    paper(p, n, 0, 0)

    bw.write("$m\n$z\n$o\n")
    bw.flush()
}

fun paper(p : ArrayList<ArrayList<Int>>, n: Int, x: Int, y:Int){
    if(n==0)
        return
    val num = p[x][y]
    for(i in x..<n+x){
        for(j in y..<n+y){
            if(num!=p[i][j]){
                paper(p, n/3, x, y)
                paper(p, n/3, x+n/3, y)
                paper(p, n/3, x+2*(n/3), y)
                paper(p, n/3, x, y+n/3)
                paper(p, n/3, x+n/3, y+n/3)
                paper(p, n/3, x+2*(n/3), y+n/3)
                paper(p, n/3, x, y+2*(n/3))
                paper(p, n/3, x+n/3, y+2*(n/3))
                paper(p, n/3, x+2*(n/3), y+2*(n/3))
                return
            }
        }
    }

    if(num == -1)
        m++
    else if(num == 0)
        z++
    else
        o++
}