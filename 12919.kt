fun main() {
    val s = readln()
    val t = readln()
    var p = false
    fun f(cur: String) {
        if(p) return
        if(cur.length == s.length) {
            if(cur == s) p = true
            return
        }
        if(cur.last() == 'A') f(cur.substring(0,cur.lastIndex))
        if(cur.first() == 'B') f(cur.reversed().substring(0, cur.lastIndex))
    }
    f(t)
    println(if(p) "1" else "0")
}
