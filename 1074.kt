import java.io.*
import kotlin.math.pow

var cnt = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N,r,c) = br.readLine().split(" ").map { it.toInt()}

    z(0,0,2.0.pow(N).toInt(),r,c)

    bw.write("$cnt")
    bw.flush()
    bw.close()
}

fun z(row : Int, column : Int, level : Int, r : Int, c : Int){
    if(row == r && column == c) return
    else {
        val size = level/2

        if(r>=row+size && c >= column+size){
            cnt += size*size*3
            z(row+size, column+size, size, r, c)
        }else if(c>=column + size) {
            cnt += size * size
            z(row, column + size, size, r, c)
        }else if(r>= row + size){
            cnt += size*size*2
            z(row+size,column,size,r,c)
        }else
            z(row, column, size, r, c)
    }
}
