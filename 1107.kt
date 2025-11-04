import kotlin.math.abs
import kotlin.math.min

fun main() {
    val input = readln()
    val length = input.length
    val target = input.toInt()
    val m = readln().toInt()
    val bn = if(m!=0) readln().split(" ").map { it.toInt() } else emptyList()
    val nums = mutableListOf<Int>()
    for(i in 0..9) {
        if(i !in bn) nums.add(i)
    }
    var result = abs(target-100)
    fun createNum(idx: Int, num : Int, s: Int) {
        if(idx == 0) {
            result = min(result, abs(target-num) + s)
            return
        }
        for(i in nums) {
            createNum(idx-1, num*10 + i, s)
        }
    }
    for(i in 1..length+1) {
        createNum(i, 0, i)
    }
    println("$result")
}
