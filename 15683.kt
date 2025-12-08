import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val to = max(n,m)
    val arr = ArrayList<List<Int>>()
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    var cnt = 0
    repeat(n) {
        val input = readln().split(" ").map { c -> c.toInt() }
        for (i in 0..<m) {
            if (input[i] in 1..5){
                q.add(it to i)
                cnt++
            }
            if(input[i] == 6) cnt++
        }
        arr.add(input)
    }
    fun simulation(cur: List<List<Int>>): Int {
        if (q.isEmpty()) return 0
        var sum = 0
        val (x, y) = q.poll()
        when (arr[x][y]) {
            1 -> {
                repeat(4) {
                    val cpy = cur.map { it.toMutableList() }.toMutableList()
                    var tmpSum = 0
                    for (i in 1..<to) {
                        if(x+dx[it]*i !in 0..<n || y+dy[it]*i !in 0..<m || cpy[x+dx[it]*i][y+dy[it]*i] == 6) break
                        if(cpy[x+dx[it]*i][y+dy[it]*i] == 0) {
                            cpy[x+dx[it]*i][y+dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    tmpSum += simulation(cpy)
                    sum = max(sum, tmpSum)
                }
            }

            2 -> {
                repeat(2) {
                    val cpy = cur.map { it.toMutableList() }.toMutableList()
                    var tmpSum = 0
                    for (i in 1..<to) {
                        if(x+dx[it]*i !in 0..<n || y+dy[it]*i !in 0..<m || cpy[x+dx[it]*i][y+dy[it]*i] == 6) break
                        if(cpy[x+dx[it]*i][y+dy[it]*i] == 0) {
                            cpy[x+dx[it]*i][y+dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    for (i in 1..<to) {
                        if(x-dx[it]*i !in 0..<n || y-dy[it]*i !in 0..<m || cpy[x-dx[it]*i][y-dy[it]*i] == 6) break
                        if(cpy[x-dx[it]*i][y-dy[it]*i] == 0) {
                            cpy[x-dx[it]*i][y-dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    tmpSum += simulation(cpy)
                    sum = max(sum, tmpSum)
                }
            }

            3 -> {
                repeat(4) {
                    val cpy = cur.map { it.toMutableList() }.toMutableList()
                    var tmpSum = 0
                    for (i in 1..<to) {
                        if(x+dx[it]*i !in 0..<n || y+dy[it]*i !in 0..<m  || cpy[x+dx[it]*i][y+dy[it]*i] == 6) break
                        if(cpy[x+dx[it]*i][y+dy[it]*i] == 0) {
                            cpy[x+dx[it]*i][y+dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    val s = (it+1)%4
                    for (i in 1..<to) {
                        if(x+dx[s]*i !in 0..<n || y+dy[s]*i !in 0..<m || cpy[x+dx[s]*i][y+dy[s]*i] == 6) break
                        if(cpy[x+dx[s]*i][y+dy[s]*i] == 0) {
                            cpy[x+dx[s]*i][y+dy[s]*i] = -1
                            tmpSum++
                        }
                    }
                    tmpSum += simulation(cpy)
                    sum = max(sum, tmpSum)
                }
            }

            4 -> {
                repeat(4) {
                    val cpy = cur.map { it.toMutableList() }.toMutableList()
                    var tmpSum = 0
                    for (i in 1..<to) {
                        if(x+dx[it]*i !in 0..<n || y+dy[it]*i !in 0..<m || cpy[x+dx[it]*i][y+dy[it]*i] == 6) break
                        if(cpy[x+dx[it]*i][y+dy[it]*i] == 0) {
                            cpy[x+dx[it]*i][y+dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    for (i in 1..<to) {
                        if(x-dx[it]*i !in 0..<n || y-dy[it]*i !in 0..<m || cpy[x-dx[it]*i][y-dy[it]*i] == 6) break
                        if(cpy[x-dx[it]*i][y-dy[it]*i] == 0) {
                            cpy[x-dx[it]*i][y-dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                    val s = (it+1)%4
                    for (i in 1..<to) {
                        if(x+dx[s]*i !in 0..<n || y+dy[s]*i !in 0..<m || cpy[x+dx[s]*i][y+dy[s]*i] == 6) break
                        if(cpy[x+dx[s]*i][y+dy[s]*i] == 0) {
                            cpy[x+dx[s]*i][y+dy[s]*i] = -1
                            tmpSum++
                        }
                    }
                    tmpSum += simulation(cpy)
                    sum = max(sum, tmpSum)
                }
            }

            else -> {
                val cpy = cur.map { it.toMutableList() }.toMutableList()
                var tmpSum = 0
                repeat(4) {
                    for (i in 1..<to) {
                        if(x+dx[it]*i !in 0..<n || y+dy[it]*i !in 0..<m || cpy[x+dx[it]*i][y+dy[it]*i] == 6) break
                        if(cpy[x+dx[it]*i][y+dy[it]*i] == 0) {
                            cpy[x+dx[it]*i][y+dy[it]*i] = -1
                            tmpSum++
                        }
                    }
                }
                tmpSum += simulation(cpy)
                sum = max(sum, tmpSum)
            }
        }
        q.add(x to y)
        return sum
    }
    println(n*m - cnt - simulation(arr))
}
