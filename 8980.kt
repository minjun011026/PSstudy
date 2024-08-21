import java.io.*
import kotlin.math.min

data class Box(
    val s : Int,
    val e : Int,
    var cnt : Int
)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val distance = Array(n){0}
    val boxes = ArrayList<Box>()
    val m = br.readLine().toInt()
    var sum = 0
    repeat(m){
        val (s,e,cnt) = br.readLine().split(" ").map {it.toInt()}
        boxes.add(Box(s,e,cnt))
    }

    boxes.sortWith(compareBy{it.e})

    for(i in 0..boxes.lastIndex){
        var minCnt = 10001
        for(j in boxes[i].s..<boxes[i].e){
            if(distance[j] < c){
                minCnt = if(distance[j]+boxes[i].cnt<=c){
                    min(minCnt,boxes[i].cnt)
                }else{
                    min(minCnt,c-distance[j])
                }
            }else{
                minCnt = 0
                break
            }
        }

        if(minCnt == 0)
            continue

        for(j in boxes[i].s..<boxes[i].e){
            distance[j] += minCnt
        }
        sum += minCnt
    }

    bw.write("$sum")
    bw.flush()
    bw.close()
}
