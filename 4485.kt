import java.util.PriorityQueue

data class Pos(
    val x : Int,
    val y : Int,
    val sum : Int
)

fun main() {
    var i = 1
    val dx = listOf(-1,0,1,0)
    val dy = listOf(0,-1,0,1)
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        val arr = Array(n) { Array(n) { Int.MAX_VALUE } }
        val cave =  Array(n) { Array(n) { 0 } }
        val q = PriorityQueue<Pos>(compareBy { it.sum })
        repeat(n) {
            cave[it] = readln().split(" ").map { it.toInt() }.toTypedArray()
        }
        q.add(Pos(0,0,cave[0][0]))
        while(true) {
            val (x,y,sum) = q.poll()
            if(arr[x][y] < sum) continue
            arr[x][y] = sum
            if(x == y && x == n-1) {
                println("Problem ${i++}: $sum")
                break
            }
            for(i in 0..3) {
                if(x+dx[i] in 0..<n && y+dy[i] in 0..<n && arr[x+dx[i]][y+dy[i]] > sum + cave[x+dx[i]][y+dy[i]]) {
                    arr[x+dx[i]][y+dy[i]] = sum + cave[x+dx[i]][y+dy[i]]
                    q.add(Pos(x+dx[i], y+dy[i], sum + cave[x+dx[i]][y+dy[i]]))
                }
            }
        }
    }
}
