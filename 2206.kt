import java.io.*
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

data class Status(
    val x : Int,
    val y : Int,
    val depth : Int,
    val isWall : Boolean
)

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map {it.toInt()}
    val arr = ArrayList<Array<Int>>()
    val q : Queue<Status> = LinkedList()
    var isVisited = Array(n) {Array(m) {false} }
    q.add(Status(0,0,1,false))
    repeat(n){
        arr.add(br.readLine().map {it.code - 48}.toTypedArray())
    }
    while(q.isNotEmpty()){
        val status = q.poll()
        if(status.x == n-1 && status.y == m-1){
            println("${status.depth}")
            return
        }

        if(status.x > 0 && arr[status.x-1][status.y] == 0 && !isVisited[status.x-1][status.y]){
            isVisited[status.x-1][status.y] = true
            q.add(Status(status.x-1,status.y,status.depth+1,status.isWall))
        }
        if(status.y > 0 && arr[status.x][status.y-1] == 0 && !isVisited[status.x][status.y-1]){
            isVisited[status.x][status.y-1] = true
            q.add(Status(status.x,status.y-1,status.depth+1,status.isWall))
        }
        if(status.x+1 < n && arr[status.x+1][status.y] == 0 && !isVisited[status.x+1][status.y]){
            isVisited[status.x+1][status.y] = true
            q.add(Status(status.x+1,status.y,status.depth+1,status.isWall))
        }
        if(status.y+1 < m && arr[status.x][status.y+1] == 0 && !isVisited[status.x][status.y+1]){
            isVisited[status.x][status.y+1] = true
            q.add(Status(status.x,status.y+1,status.depth+1,status.isWall))
        }

        if(status.x > 0 && arr[status.x-1][status.y] == 1 && !status.isWall && !isVisited[status.x-1][status.y]){
            isVisited[status.x-1][status.y] = true
            q.add(Status(status.x-1,status.y,status.depth+1, true))
        }
        if(status.y > 0 && arr[status.x][status.y-1] == 1 && !status.isWall && !isVisited[status.x][status.y-1]){
            isVisited[status.x][status.y-1] = true
            q.add(Status(status.x,status.y-1,status.depth+1,true))
        }
        if(status.x+1 < n && arr[status.x+1][status.y] == 1 && !status.isWall && !isVisited[status.x+1][status.y]){
            isVisited[status.x+1][status.y] = true
            q.add(Status(status.x+1,status.y,status.depth+1,true))
        }
        if(status.y+1 < m && arr[status.x][status.y+1] == 1 && !status.isWall && !isVisited[status.x][status.y+1]){
            isVisited[status.x][status.y+1] = true
            q.add(Status(status.x,status.y+1,status.depth+1,true))
        }
    }
    isVisited = Array(n) {Array(m) {false} }
    q.add(Status(n-1,m-1,1,false))
    while(q.isNotEmpty()){
        val status = q.poll()
        if(status.x == 0 && status.y == 0){
            println("${status.depth}")
            return
        }

        if(status.x > 0 && arr[status.x-1][status.y] == 0 && !isVisited[status.x-1][status.y]){
            isVisited[status.x-1][status.y] = true
            q.add(Status(status.x-1,status.y,status.depth+1,status.isWall))
        }
        if(status.y > 0 && arr[status.x][status.y-1] == 0 && !isVisited[status.x][status.y-1]){
            isVisited[status.x][status.y-1] = true
            q.add(Status(status.x,status.y-1,status.depth+1,status.isWall))
        }
        if(status.x+1 < n && arr[status.x+1][status.y] == 0 && !isVisited[status.x+1][status.y]){
            isVisited[status.x+1][status.y] = true
            q.add(Status(status.x+1,status.y,status.depth+1,status.isWall))
        }
        if(status.y+1 < m && arr[status.x][status.y+1] == 0 && !isVisited[status.x][status.y+1]){
            isVisited[status.x][status.y+1] = true
            q.add(Status(status.x,status.y+1,status.depth+1,status.isWall))
        }

        if(status.x > 0 && arr[status.x-1][status.y] == 1 && !status.isWall && !isVisited[status.x-1][status.y]){
            isVisited[status.x-1][status.y] = true
            q.add(Status(status.x-1,status.y,status.depth+1, true))
        }
        if(status.y > 0 && arr[status.x][status.y-1] == 1 && !status.isWall && !isVisited[status.x][status.y-1]){
            isVisited[status.x][status.y-1] = true
            q.add(Status(status.x,status.y-1,status.depth+1,true))
        }
        if(status.x+1 < n && arr[status.x+1][status.y] == 1 && !status.isWall && !isVisited[status.x+1][status.y]){
            isVisited[status.x+1][status.y] = true
            q.add(Status(status.x+1,status.y,status.depth+1,true))
        }
        if(status.y+1 < m && arr[status.x][status.y+1] == 1 && !status.isWall && !isVisited[status.x][status.y+1]){
            isVisited[status.x][status.y+1] = true
            q.add(Status(status.x,status.y+1,status.depth+1,true))
        }
    }
    bw.write("-1")
    bw.flush()
    bw.close()
}

