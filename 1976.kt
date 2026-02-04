import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val isRoute = Array(n) { Array(n) { false } }
    var visit : Array<Boolean>
    val q : Queue<Int> = LinkedList()
    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        for (i in 0..<n) if(input[i] == 1 || it == i) isRoute[it][i] = true
    }
    val plan = readln().split(" ").map { it.toInt() }

    for (i in 0..<n) {
        visit = Array(n) { false }
        q.add(i)
        visit[i] = true
        while(q.isNotEmpty()) {
            val cur = q.poll()
            for(j in 0..<n) {
                if(isRoute[cur][j] && !visit[j]) {
                    isRoute[i][j] = true
                    visit[j] = true
                    q.add(j)
                }
            }
        }
    }
    var before = plan[0] - 1
    var isPossible = true
    for(i in 1..<m) {
        if(isRoute[before][plan[i]-1]) before = plan[i]-1
        else isPossible = false
    }
    if(isPossible) println("YES") else println("NO")
}
