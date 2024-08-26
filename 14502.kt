import java.io.*
import java.util.*
import kotlin.math.max

var answer = 0

data class Pos(
    val i : Int,
    val j : Int
)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n,m) = br.readLine().split(" ").map {it.toInt()}
    val lab = ArrayList<ArrayList<Int>>()
    val virusPos = ArrayList<Pos>()
    repeat(n){
        lab.add(br.readLine().split(" ").map {it.toInt()} as ArrayList<Int>)
    }

    for(i in 0..< n){
        for(j in 0..< m){
            if(lab[i][j] == 2) virusPos.add(Pos(i,j))
        }
    }

    dfs(lab, n, m, 0, virusPos)
    bw.write("$answer")
    bw.flush()
    bw.close()
}

fun dfs(lab: ArrayList<ArrayList<Int>>, n: Int, m: Int, cnt: Int, virusPos : ArrayList<Pos>) {
    if(cnt == 3){
        virus(lab,virusPos)
        return
    }

    for(i in 0..<n){
        for(j in 0..< m){
            if(lab[i][j] == 0){
                lab[i][j] = 1
                dfs(lab,n,m,cnt+1,virusPos)
                lab[i][j] = 0
            }
        }
    }
}

fun virus(lab : ArrayList<ArrayList<Int>>, virusPos : ArrayList<Pos>){
    var sum = 0
    val queue : Queue<Pos> = LinkedList()
    queue.addAll(virusPos)
    val visited = Array(lab.size) {Array(lab[0].size) {0}}
    while(queue.isNotEmpty()){
        val tmp = queue.poll()
        visited[tmp.i][tmp.j] = 1

        if(tmp.i+1 <= lab.lastIndex && lab[tmp.i+1][tmp.j] == 0 && visited[tmp.i+1][tmp.j]==0){
            queue.add(Pos(tmp.i+1,tmp.j))
            visited[tmp.i+1][tmp.j]=1
        }
        if(tmp.j+1 <= lab[0].lastIndex && lab[tmp.i][tmp.j+1] == 0 && visited[tmp.i][tmp.j+1]==0){
            queue.add(Pos(tmp.i,tmp.j+1))
            visited[tmp.i][tmp.j+1]=1
        }
        if(tmp.i-1 >=0 && lab[tmp.i-1][tmp.j] == 0 && visited[tmp.i-1][tmp.j]==0){
            queue.add(Pos(tmp.i-1,tmp.j))
            visited[tmp.i-1][tmp.j]=1
        }
        if(tmp.j-1 >=0 && lab[tmp.i][tmp.j-1] == 0 && visited[tmp.i][tmp.j-1]==0){
            queue.add(Pos(tmp.i,tmp.j-1))
            visited[tmp.i][tmp.j-1]=1
        }
    }

    for(i in 0..lab.lastIndex){
        for(j in 0..lab[0].lastIndex){
            if(lab[i][j] == 0 && visited[i][j]==0) sum++
        }
    }

    answer = max(answer,sum)
}
