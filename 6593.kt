import java.io.*
import java.util.*

data class Position(
    val x : Int,
    val y : Int,
    val z : Int,
    val t : Int
)

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        val (L, R, C) = br.readLine().split(" ").map {it.toInt()}
        val arr = Array(L){ArrayList<Array<Char>>()}
        if(L == R && R == C && C == 0) break
        val queue : Queue<Position> = LinkedList()
        val chk = Array(L){Array(R){Array(C){false} } }
        var end = Triple(0,0,0)
        var isEscape = false
        repeat(L){
            i->
            repeat(R){
                j->
                val tmp = br.readLine().map{it}.toTypedArray()
                arr[i].add(tmp)
                if(tmp.contains('S')) queue.add(Position(i,j,tmp.indexOf('S'),0))
                if(tmp.contains('E')) end = Triple(i,j,tmp.indexOf('E'))
            }
            br.readLine()
        }
        while(queue.isNotEmpty() && !isEscape){
            val (x,y,z,t) = queue.poll()
            
            if(x == end.first && y == end.second && z == end.third) {
                isEscape = true
                bw.write("Escaped in $t minute(s).\n")
            }

            if(x+1 < L && (arr[x+1][y][z] == '.' || arr[x+1][y][z] == 'E') && !chk[x+1][y][z]){
                queue.add(Position(x+1, y, z,t+1))
                chk[x+1][y][z] = true
            }
            if(x-1 >= 0 && (arr[x-1][y][z] == '.' || arr[x-1][y][z] == 'E') && !chk[x-1][y][z]){
                queue.add(Position(x-1, y, z,t+1))
                chk[x-1][y][z] = true
            }
            if(y+1 < R && (arr[x][y+1][z] == '.' || arr[x][y+1][z] == 'E') && !chk[x][y+1][z]){
                queue.add(Position(x, y+1, z,t+1))
                chk[x][y+1][z] = true
            }
            if(y-1 >= 0 && (arr[x][y-1][z] == '.' || arr[x][y-1][z] == 'E') && !chk[x][y-1][z]){
                queue.add(Position(x, y-1, z,t+1))
                chk[x][y-1][z] = true
            }
            if(z+1 < C && (arr[x][y][z+1] == '.' || arr[x][y][z+1] == 'E') && !chk[x][y][z+1]){
                queue.add(Position(x, y, z+1,t+1))
                chk[x][y][z+1] = true
            }
            if(z-1 >= 0 && (arr[x][y][z-1] == '.' || arr[x][y][z-1] == 'E') && !chk[x][y][z-1]){
                queue.add(Position(x, y, z-1,t+1))
                chk[x][y][z-1] = true
            }
        }
        if(!isEscape) bw.write("Trapped!\n")
    }

    bw.flush()
    bw.close()
}



