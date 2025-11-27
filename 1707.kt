import java.util.*

fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        val edge = Array(v+1) { mutableSetOf<Int>() }
        val s1 = mutableSetOf<Int>()
        val s2 = mutableSetOf<Int>()
        var isBinary = true
        repeat(e) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            edge[a].add(b)
            edge[b].add(a)
        }
        val q : Queue<Int> = LinkedList()
        val isVisit = Array(v+1) { false }
        for(i in 1..v) {
            if(isVisit[i]) continue
            q.add(i)
            s1.add(i)
            isVisit[i] = true
            while(q.isNotEmpty()) {
                val idx = q.poll()
                val isOne = s1.contains(idx)
                for(j in edge[idx]) {
                    if(!isVisit[j]) {
                        q.add(j)
                        isVisit[j] = true
                        if (isOne) s2.add(j) else s1.add(j)
                    }
                }
            }
        }
        for(i in s2) {
            if(!isBinary) break
            for(j in edge[i]) {
                if(s2.contains(j)) {
                    isBinary = false
                    break
                }
            }
        }
        for(i in s1) {
            if(!isBinary) break
            for(j in edge[i]) {
                if(s1.contains(j)) {
                    isBinary = false
                    break
                }
            }
        }
        if(isBinary) println("YES")
        else println("NO")
    }
}
