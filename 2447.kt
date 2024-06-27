import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val s = Array<CharArray>(n) { CharArray(n) }

    star(s, n, 0, 0)

    for(i in 0..<n)
        bw.write(s[i].joinToString("")+"\n")
    bw.flush()
}

fun star(s : Array<CharArray>, n: Int, x: Int, y:Int){
    if(n==1)
        return

    if(n==3){
        for(i in x..x+2){
            for(j in y..y+2){
                if(j == y+1 && i == x+1)
                    s[i][j] = ' '
                else
                    s[i][j] = '*'
            }
        }
    }

    star(s, n/3, x, y)
    star(s, n/3, x+n/3, y)
    star(s, n/3, x+2*(n/3), y)
    star(s, n/3, x, y+n/3)
    for(i in x+n/3..<x+2*(n/3)){
        for(j in y+n/3..<y+2*(n/3)){
            s[i][j] = ' '
        }
    }
    star(s, n/3, x+2*(n/3), y+n/3)
    star(s, n/3, x, y+2*(n/3))
    star(s, n/3, x+n/3, y+2*(n/3))
    star(s, n/3, x+2*(n/3), y+2*(n/3))
}