import java.util.Stack

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val num = readln().map { it.code - 48 }.toMutableList()
    var cnt = 0
    val s1 = Stack<Int>()
    val s2 = Stack<Int>()
    s2.addAll(num.reversed())
    while(cnt<k) {
        if(s2.isEmpty()) {
            s1.pop()
            cnt++
            continue
        }
        if(s1.isEmpty()) s1.add(s2.pop())
        if(s1.peek() < s2.peek()) {
            s1.pop()
            cnt++
        } else {
            s1.add(s2.pop())
        }
    }
    println(s1.joinToString("")+s2.reversed().joinToString(""))
}
