import kotlin.math.max

fun main() {
    val s = readln()
    val t = readln()
    var before = Array(t.length + 1) { 0 }
    var current = Array(t.length + 1) { 0 }
    var max = Int.MIN_VALUE

    for(i in 1.. s.length) {
        for(j in 1..t.length) {
            if(s[i-1] == t[j-1]) {
                current[j] = before[j-1] + 1
            }
        }
        max = max(max, current.max())
        before = current
        current = Array(t.length + 1) { 0 }
    }

    println(max)
}
