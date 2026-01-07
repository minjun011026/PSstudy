import java.util.*
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val length = Array(n + 1) { 0 }
    val visit = Array(n+1) { false }
    val m = mutableMapOf<Int, ArrayList<Pair<Int,Int>>>()
    var start = 1
    repeat(n - 1) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if(!m.containsKey(a)) m[a] = ArrayList()
        if(!m.containsKey(b)) m[b] = ArrayList()
        m[a]!!.add(b to c)
        m[b]!!.add(a to c)
    }
    for(i in m.keys) {
        if(m[i]!!.size == 1) {
            start = i
            break
        }
    }
    fun calc(idx : Int, sum : Int, w : Int) : Int {
        visit[idx] = true
        var max = 0
        var sMax = 0
        m[idx]?.let { it ->
            for((a,b) in it) {
                if(!visit[a]) {
                    val tmp = calc(a, sum + b, b)
                    if (max < tmp) {
                        sMax = max
                        max = tmp
                    } else if(sMax < tmp) sMax = tmp
                }
            }
        }
        length[idx] = max(max+sMax, max+sum)
        return max + w
    }
    if(n>1) {
        val (next, dis) = m[start]!![0]
        visit[start] = true
        length[start] = calc(next, dis, dis)
    }
    println(length.max())
}
