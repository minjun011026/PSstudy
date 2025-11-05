data class Node(
    val value:Char,
    val m: MutableMap<Char, Node>,
    val isEnd: Boolean
)


fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val head = Node(' ',mutableMapOf(),false)
        val arr = ArrayList<String>()
        repeat(n) {
            arr.add(readln())
        }
        var isIn = false
        for(num in arr) {
            var cur = head
            for(c in 0..< num.length) {
                if(c == num.length-1) {
                    val x = cur.m[num[c]]
                    if(x == null) {
                        cur.m[num[c]] = Node(num[c],mutableMapOf(), true)
                    } else {
                        isIn = true
                    }
                }else {
                    val x = cur.m[num[c]]
                    if(x == null) {
                        cur.m[num[c]] = Node(num[c],mutableMapOf(), false)
                    } else {
                        if(x.isEnd) isIn = true
                    }
                    cur = cur.m[num[c]]!!
                }
            }
        }
        if(isIn) println("NO") else println("YES")
    }
}
