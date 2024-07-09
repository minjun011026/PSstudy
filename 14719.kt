import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (h,w) = br.readLine().split(" ").map {it.toInt()}
    val block = br.readLine().split(" ").map {it.toInt()}

    val td = Array(w) { IntArray(h) }

    for(i in 0..<w){
        for(j in 0..<block[i])
            td[i][j] = 1
    }

    var sum = 0

    for(i in 0..<h){
        var isWall = false
        var temp = 0
        for(j in 0..<w){
            if(td[j][i] == 1){
                if(!isWall) {
                    isWall = true
                    temp = 0
                } else{
                    sum += temp
                    temp = 0
                }
            }else
                temp+=1
        }
    }
    bw.write("$sum\n")
    bw.flush()
}