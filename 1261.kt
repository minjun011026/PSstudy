import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { Array(m) { ' ' } }
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    repeat(n) {
        arr[it] = readln().map { c -> c }.toTypedArray()
    }
    var cnt1 = Int.MAX_VALUE
    var cnt2 = Int.MAX_VALUE
    val q = PriorityQueue<Triple<Int,Int,Int>>( compareBy { it.third })
    var visit = Array(n) { Array(m) { false } }
    q.add(Triple(0, 0, 0))
    visit[0][0] = true
    while (q.isNotEmpty()) {
        val (x, y, cnt) = q.poll()
        if (x == n - 1 && y == m - 1) cnt1 = min(cnt1, cnt)
        for (i in 0..3) {
            if (x + dx[i] in 0..<n && y + dy[i] in 0..<m && !visit[x + dx[i]][y + dy[i]]) {
                visit[x + dx[i]][y + dy[i]] = true
                q.add(Triple(x + dx[i], y + dy[i], if (arr[x + dx[i]][y + dy[i]] == '1') cnt + 1 else cnt))
            }
        }
    }

    visit = Array(n) { Array(m) { false } }
    q.add(Triple(n - 1, m - 1, 0))
    visit[n - 1][m - 1] = true
    while (q.isNotEmpty()) {
        val (x, y, cnt) = q.poll()
        if (x == 0 && y == 0) cnt2 = min(cnt2, cnt)
        for (i in 0..3) {
            if (x + dx[i] in 0..<n && y + dy[i] in 0..<m && !visit[x + dx[i]][y + dy[i]]) {
                visit[x + dx[i]][y + dy[i]] = true
                q.add(Triple(x + dx[i], y + dy[i], if (arr[x + dx[i]][y + dy[i]] == '1') cnt + 1 else cnt))
            }
        }
    }
    println(min(cnt1, cnt2))
}
