import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n){
        val (w, h) = br.readLine().split(" ").map {it.toInt()}
        val building = ArrayList<Array<Char>>()
        val queue1 : Deque<IntArray> = LinkedList()
        val queue2 : Deque<IntArray> = LinkedList()
        val chk = Array(h){Array(w){false}}
        val chk2 = Array(h){Array(w){false}}
        var time = 0
        var isEscape = false
        repeat(h){
            val tmp = br.readLine().map{it}.toTypedArray()
            building.add(tmp)
            if(tmp.contains('@')){
                queue1.add(intArrayOf(it, tmp.indexOf('@'), 0))
            }
            if(tmp.contains('*')){
                for(i in 0..<w){
                    if(tmp[i]=='*') queue2.add(intArrayOf(it, i, 0))
                }
            }
        }
        while(queue1.isNotEmpty() && !isEscape){
            while(queue1.isNotEmpty()) {
                val (i, j, t) = queue1.poll()
                if(t!=time){
                    queue1.addFirst(intArrayOf(i,j,t))
                    break
                }
                if (!chk[i][j]) {
                    building[i][j] = '@'
                    if (i == h - 1 || i == 0 || j == w - 1 || j == 0) {
                        isEscape = true
                        break
                    }
                    if (i + 1 < h && building[i + 1][j] == '.' && !chk2[i+1][j]) {
                        queue1.add(intArrayOf(i + 1, j, t + 1))
                        chk2[i+1][j] = true
                    }
                    if (building[i - 1][j] == '.' && !chk2[i-1][j]) {
                        queue1.add(intArrayOf(i - 1, j, t + 1))
                        chk2[i-1][j] = true
                    }
                    if (j + 1 < w && building[i][j + 1] == '.' && !chk2[i][j+1]) {
                        queue1.add(intArrayOf(i, j + 1, t + 1))
                        chk2[i][j+1] = true
                    }
                    if (building[i][j - 1] == '.' && !chk2[i][j-1]) {
                        queue1.add(intArrayOf(i, j - 1, t + 1))
                        chk2[i][j-1] = true
                    }
                }
            }

            while(queue2.isNotEmpty()){
                val (x,y,z) = queue2.poll()
                if(z!=time){
                    queue2.addFirst(intArrayOf(x,y,z))
                    break
                }
                building[x][y] = '*'
                if(x+1<h && (building[x+1][y] == '.' || building[x+1][y] == '@') && !chk[x+1][y]) {
                    queue2.add(intArrayOf(x + 1, y, z + 1))
                    chk[x+1][y] = true
                }
                if(x-1 >= 0 && (building[x-1][y] == '.'|| building[x-1][y] == '@')&& !chk[x-1][y]) {
                    queue2.add(intArrayOf(x-1,y,z+1))
                    chk[x-1][y] = true
                }
                if(y+1<w && (building[x][y+1] == '.' || building[x][y+1] == '@')&& !chk[x][y+1]) {
                    queue2.add(intArrayOf(x,y+1,z+1))
                    chk[x][y+1] = true
                }
                if(y-1>=0 && (building[x][y-1] == '.' || building[x][y-1] == '@') && !chk[x][y-1]) {
                    queue2.add(intArrayOf(x,y-1,z+1))
                    chk[x][y-1] = true
                }
            }

            time++
        }
        if(isEscape) bw.write("${time}\n")
        else bw.write("IMPOSSIBLE\n")
    }
    bw.flush()
    bw.close()
}

