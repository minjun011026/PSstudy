import java.io.*
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = ArrayList<Array<Int>>()
    var sharkX = 0
    var sharkY = 0
    var size = 2
    var eatCnt = 0
    repeat(n){
        val input = br.readLine().split(" ").map {it.toInt()}.toTypedArray()
        arr.add(input)
        if(input.contains(9)){
            sharkX = it
            sharkY = input.indexOf(9)
        }
    }
    var closestX = sharkX
    var closestY = sharkY
    var sum = 0
    var length = 0
    var isVisit : Array<Array<Boolean>>
    while(true){
        isVisit = Array(n) {Array(n) {false} }
        val queue : Queue<Triple<Int,Int,Int>> = LinkedList()
        queue.add(Triple(sharkX,sharkY,0))
        arr[sharkX][sharkY] = 0
        isVisit[sharkX][sharkY] = true
        while(true){
            val (x, y, depth) = queue.poll()
            if(arr[x][y] in 1..<size){
                closestX = x
                closestY = y
                length = depth
                while(queue.isNotEmpty()){
                    val (x2, y2, length2) = queue.poll()
                    if(arr[x2][y2] in 1..<size && length2 <= length) {
                        if(x2<closestX){
                            closestX = x2
                            closestY = y2
                            length = length2
                        }else if(x2 == closestX && y2 < closestY){
                            closestX = x2
                            closestY = y2
                            length = length2
                        }
                    }
                }
                break
            }
            if(x > 0 && !isVisit[x-1][y] && arr[x-1][y] <= size){
                isVisit[x-1][y] = true
                queue.add(Triple(x-1,y,depth+1))
            }
            if(y > 0 && !isVisit[x][y-1] && arr[x][y-1] <= size){
                isVisit[x][y-1] = true
                queue.add(Triple(x,y-1,depth+1))
            }
            if(y + 1 < n && !isVisit[x][y+1] && arr[x][y+1] <= size){
                isVisit[x][y+1] = true
                queue.add(Triple(x,y+1,depth+1))
            }
            if(x+1 < n && !isVisit[x+1][y] && arr[x+1][y] <= size){
                isVisit[x+1][y] = true
                queue.add(Triple(x+1,y,depth+1))
            }
            if(queue.isEmpty()) break
        }
        if(closestX == sharkX && closestY == sharkY) break
        sum += length
        sharkX = closestX
        sharkY = closestY
        eatCnt++
        if(eatCnt == size) {
            size++
            eatCnt = 0
        }
    }
    bw.write("$sum")
    bw.flush()
    bw.close()
}

