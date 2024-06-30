import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Long.min
import java.util.*
import kotlin.math.pow

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (l, w, h) = br.readLine().split(' ').map {it.toLong()}
    val cube = ArrayList<Long>()
    var cnt:Long = 0

    val n = br.readLine().toInt()
    repeat(n){
        val (a, b) = br.readLine().split(' ').map {it.toLong()}
        cube.add(b)
    }

    var div:Long = 0

    for(i in cube.lastIndex downTo 0){
        div *= 8

        val possibleCube:Long = (l/(2.0.pow(i).toLong())) * (w/(2.0.pow(i).toLong())) * (h/(2.0.pow(i).toLong())) - div
        val newCube:Long = min(cube[i].toLong(),possibleCube)

        div += newCube
        cnt += newCube
    }

    if(div==l*w*h)
        bw.write("$cnt\n")
    else
        bw.write("-1\n")
    bw.flush()
}