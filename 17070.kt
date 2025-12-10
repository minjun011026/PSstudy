data class Pipe(
    val x: Int,
    val y: Int,
    val dir: Int
)

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { Array(n) { 0 } }
    repeat(n) {
        arr[it] = readln().split(" ").map { it.toInt() }.toTypedArray()
    }

    fun dp(pipe: Pipe): Int {
        if (pipe.x == n - 1 && pipe.y == n - 1) return 1
        var sum = 0
        when (pipe.dir) {
            0 -> {
                if (pipe.y + 1 in 0..<n && arr[pipe.x][pipe.y + 1] == 0) {
                    sum += dp(pipe.copy(y = pipe.y + 1))
                    if (pipe.x + 1 in 0..<n && arr[pipe.x + 1][pipe.y] == 0 && arr[pipe.x + 1][pipe.y + 1] == 0)
                        sum += dp(Pipe(pipe.x + 1, pipe.y + 1, 2))
                }
            }

            1 -> {
                if (pipe.x + 1 in 0..<n && arr[pipe.x+1][pipe.y] == 0) {
                    sum += dp(pipe.copy(x = pipe.x + 1))
                    if (pipe.y + 1 in 0..<n && arr[pipe.x][pipe.y+1] == 0 && arr[pipe.x + 1][pipe.y + 1] == 0)
                        sum += dp(Pipe(pipe.x + 1, pipe.y + 1, 2))
                }
            }

            2 -> {
                if (pipe.y + 1 in 0..<n && arr[pipe.x][pipe.y + 1] == 0) {
                    sum += dp(pipe.copy(y = pipe.y + 1, dir = 0))
                    if (pipe.x + 1 in 0..<n && arr[pipe.x + 1][pipe.y] == 0 && arr[pipe.x + 1][pipe.y + 1] == 0)
                        sum += dp(Pipe(pipe.x + 1, pipe.y + 1, 2))
                }
                if (pipe.x + 1 in 0..<n && arr[pipe.x+1][pipe.y] == 0) sum += dp(pipe.copy(x = pipe.x + 1, dir = 1))
            }
        }
        return sum
    }

    println(dp(Pipe(0, 1, 0)))
}
