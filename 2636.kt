import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { Array(m) { 0 } }
    val q : Queue<Pair<Int, Int>> = LinkedList()
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, -1, 0, 1)
    var cnt = 0
    var cheeseCnt = 0
    var isVisit = Array(n) { Array(m) { false } }

    repeat(n) {
        arr[it] = readln().split(" ").map { e -> e.toInt() }.toTypedArray()
    }

    fun dfs(x: Int, y: Int) {
        q.add(x to y)
        for(i in 0..3) {
            if(x+dx[i] in 0..<n && y+dy[i] in 0..<m && arr[x+dx[i]][y+dy[i]] == 0 && !isVisit[x+dx[i]][y+dy[i]]) {
                isVisit[x+dx[i]][y+dy[i]] = true
                dfs(x+dx[i],y+dy[i])
            }
        }
    }

    while (true) {
        isVisit = Array(n) { Array(m) { false } }
        dfs(0,0)
        val s = q.size
        var curCnt = 0
        repeat(s) {
            val (x, y) = q.poll()
            for(i in 0..3) {
                if(x+dx[i] in 0..<n && y+dy[i] in 0..<m && arr[x+dx[i]][y+dy[i]] == 1) {
                    arr[x+dx[i]][y+dy[i]] = 0
                    curCnt++
                }
            }
            q.add(x to y)
        }
        if(curCnt == 0) break
        cnt++
        cheeseCnt = curCnt
    }
    println("$cnt\n$cheeseCnt")
}
