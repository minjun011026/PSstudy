import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val dur = readln().split(" ").map { it.toInt() }.toMutableList()
    val isRb = Array(2*n) { false }
    val upQ : Queue<Int> = LinkedList()
    val rbQ : Queue<Pair<Int, Int>> = LinkedList()
    var t = 0
    var cnt = 0
    upQ.add(0)
    upQ.addAll((1..<2*n).reversed())

    while(cnt<k) {
        t++
        upQ.add(upQ.poll())
        repeat(rbQ.size) {
            val (pos, idx) = rbQ.poll()
            if(pos+1 == n - 1) isRb[idx] = false
            else {
                val next = (idx+1) % (2*n)
                if(!isRb[next] && dur[next] >= 1) {
                    isRb[idx] = false
                    dur[next]--
                    if (dur[next] == 0) cnt++
                    if(pos+2 != n - 1) {
                        isRb[next] = true
                        rbQ.add(pos + 2 to next)
                    }
                } else rbQ.add(pos+1 to idx)
            }
        }
        val top = upQ.peek()
        if(!isRb[top] && dur[top] >= 1) {
            isRb[top] = true
            rbQ.add(0 to top)
            dur[top]--
            if(dur[top] == 0) cnt++
        }
    }

    println(t)
}
