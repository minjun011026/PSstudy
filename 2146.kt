import java.io.*
import java.util.*

data class Island(
    val num : Int,
    var islandNum : Int,
)

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val country = Array(n){Array(n){Island(0,0)}}
    var cnt = 1
    val chk  =Array(n){Array(n){false}}
    val queue : Queue<IntArray> = LinkedList()
    repeat(n){
        country[it] = br.readLine().split(" ").map {Island(it.toInt(), 0)}.toTypedArray()
    }
    for(i in 0..<n){
        for(j in 0..< n){
            if(country[i][j].num == 1 && !chk[i][j]){
                dfs(i,j,country, cnt, chk)
                cnt++
            }
        }
    }

    var min = 400
    for(i in 0..< n){
        for(j in 0..< n){
            if(country[i][j].num == 1){
                for (k in 0 ..< n)
                    Arrays.fill(chk[k], false)
                queue.add(intArrayOf(i, j, 0))
                chk[i][j] = true
                while(queue.isNotEmpty()){
                    val (x,y, z) = queue.poll()
                    if(country[x][y].islandNum>0 && country[x][y].islandNum != country[i][j].islandNum){
                        if(z < min) min = z
                        break
                    }
                    if(x-1>=0 && country[x-1][y].islandNum != country[i][j].islandNum && !chk[x-1][y]) {
                        queue.add(intArrayOf(x-1,y,z+1))
                        chk[x-1][y] = true
                    }
                    if(x+1<n && country[x+1][y].islandNum != country[i][j].islandNum  && !chk[x+1][y]) {
                        queue.add(intArrayOf(x+1,y,z+1))
                        chk[x+1][y] = true
                    }
                    if(y-1>=0 && country[x][y-1].islandNum != country[i][j].islandNum && !chk[x][y-1]){
                        queue.add(intArrayOf(x,y-1,z+1))
                        chk[x][y-1] = true
                    }
                    if(y+1<n && country[x][y+1].islandNum != country[i][j].islandNum  && !chk[x][y+1]) {
                        queue.add(intArrayOf(x,y+1,z+1))
                        chk[x][y+1] = true
                    }
                }
                queue.clear()
            }
        }
    }

    bw.write("${min-1}")
    bw.flush()
    bw.close()
}

fun dfs(i : Int, j : Int, arr : Array<Array<Island>>, cnt : Int, chk : Array<Array<Boolean>>) {
    arr[i][j].islandNum = cnt
    chk[i][j] = true
    if(i-1>=0 && arr[i-1][j].num == 1 &&!chk[i-1][j]) dfs(i-1,j,arr, cnt, chk)
    if(i+1<=arr.lastIndex && arr[i+1][j].num == 1 && !chk[i+1][j]) dfs(i+1,j,arr, cnt, chk)
    if(j-1>=0 && arr[i][j-1].num == 1 && !chk[i][j-1]) dfs(i,j-1,arr, cnt, chk)
    if(j+1<=arr[0].lastIndex && arr[i][j+1].num == 1 && !chk[i][j+1]) dfs(i,j+1,arr, cnt,chk)
}
