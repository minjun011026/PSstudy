import java.util.Stack

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val edges = Array(v) { mutableListOf<Int>() }
    var isExist = false
    val s = Stack<Pair<Int, Set<Int>>>()
    repeat(e) {
        val (a,b) = readln().split(" ").map { it.toInt() }
        edges[a].add(b)
        edges[b].add(a)
    }

    for(i in 0..<v) {
        if(isExist) break
        s.push(i to setOf(i))
        while(s.isNotEmpty()) {
            val (idx, route) = s.pop()
            if(route.size >= 5) {
                isExist = true
                break
            }
            for(node in edges[idx]) {
                if(!route.contains(node)) s.push(node to route + node)
            }
        }
    }
    if(isExist) println(1) else println(0)
}
