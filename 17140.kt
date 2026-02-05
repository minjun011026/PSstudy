fun main() {
    var cnt = 0
    val (r, c, k) = readln().split(" ").map { it.toInt() }
    val arr = ArrayList<ArrayList<Int>>()
    repeat(3) {
        arr.add(ArrayList(readln().split(" ").map { it.toInt() }))
    }
    while (true) {
        var maxLength = 0

        if (r <= arr.size && c <= arr[0].size && arr[r - 1][c - 1] == k) break
        if(cnt == 100) {
            cnt = -1
            break
        }
        if (arr.size >= arr[0].size) {
            for (i in 0..<arr.size) {
                val m = mutableMapOf<Int, Int>()
                for (j in arr[i]) if(j != 0) m[j] = m.getOrDefault(j, 0) + 1
                val newR = m.map { (key, value) -> key to value }.sortedWith(compareBy({ it.second }, { it.first })).flatMap { listOf(it.first, it.second) }
                if(newR.size > 100) arr[i] = ArrayList(m.map { (key, value) -> key to value }.sortedWith(compareBy({ it.second }, { it.first })).flatMap { listOf(it.first, it.second) }.subList(0,100))
                else arr[i] = ArrayList(m.map { (key, value) -> key to value }.sortedWith(compareBy({ it.second }, { it.first })).flatMap { listOf(it.first, it.second) })
                if(maxLength < arr[i].size) maxLength = arr[i].size
            }
            if(maxLength > 100) maxLength = 100
            for(i in 0..<arr.size) {
                if(arr[i].size < maxLength) {
                    val tmp = arr[i].size
                    repeat(maxLength-tmp) {
                        arr[i].add(0)
                    }
                }
            }
        } else {
            val cSize = arr.size
            val tmp = ArrayList<List<Int>>()
            for(i in 0..<arr[0].size) {
                val m = mutableMapOf<Int, Int>()
                for(j in 0..<cSize) if(arr[j][i] != 0) m[arr[j][i]] = m.getOrDefault(arr[j][i], 0) + 1
                tmp.add(m.map { (key, value) -> key to value }.sortedWith(compareBy({ it.second }, { it.first })).flatMap { listOf(it.first, it.second) })
                if(maxLength < tmp.last().size) maxLength = tmp.last().size
            }
            if(maxLength > 100) maxLength = 100
            for(i in 0..<tmp.size) {
                for(j in 0..<maxLength) {
                    if(j < tmp[i].size) {
                        if(j >= arr.size) {
                            val nR = List(tmp.size, { 0 })
                            arr.add(ArrayList(nR))
                        }
                        arr[j][i] = tmp[i][j]
                    } else {
                        if(j >= arr.size) {
                            val nR = List(tmp.size, { 0 })
                            arr.add(ArrayList(nR))
                        }
                        arr[j][i] = 0
                    }
                }
                for(j in maxLength..<arr.size) arr[j][i] = 0
            }
        }
        cnt++
    }
    println(cnt)
}
