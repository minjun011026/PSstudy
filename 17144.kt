fun main() {
    val (R, C, T) = readln().split(" ").map { it.toInt() }
    var current = Array(R) { IntArray(C) }
    var next = Array(R) { IntArray(C) }
    val ac = ArrayList<Pair<Int,Int>>()
    val dr = listOf(-1,0,1,0)
    val dc = listOf(0,-1,0,1)
    repeat(R) {
        val input = readln().split(" ").map { it.toInt() }
        for(i in 0..< C) {
            if(input[i] == -1) ac.add(it to i)
        }
        current[it] = input.toIntArray()
    }
    repeat(T) {
        for (row in next) row.fill(0)
        for (i in ac) next[i.first][i.second] = -1

        for (r in 0 until R) {
            for (c in 0 until C) {
                if (current[r][c] > 0) {
                    next[r][c] += current[r][c]
                    for(i in 0..3) {
                        if(r+dr[i] in 0..<R && c+dc[i] in 0..<C && next[r+dr[i]][c+dc[i]] != -1) {
                            next[r+dr[i]][c+dc[i]] += current[r][c] / 5
                            next[r][c] -= current[r][c] / 5
                        }
                    }
                }
            }
        }

        val tmp = current
        current = next
        next = tmp

        var (r, c) = ac[0]
        r--
        var (br, bc) = r to c
        current[r][c] = 0
        while(true) {
            if(c == 0) {
                if(r != 0) r--
                else c++
            }else if(c == C-1) {
                if(r != ac[0].first) r++
                else c--
            } else {
                if(r == 0) c++
                else c--
            }
            if(r == ac[0].first && c == ac[0].second) {
                current[br][bc] = 0
                break
            }
            current[br][bc] = current[r][c]
            br = r
            bc = c
        }
        r = ac[1].first
        c = ac[1].second
        r++
        br = r
        bc = c
        current[r][c] = 0
        while(true) {
            if(c == 0) {
                if(r != R-1) r++
                else c++
            }else if(c == C-1) {
                if(r != ac[1].first) r--
                else c--
            } else {
                if(r == R-1) c++
                else c--
            }
            if(r == ac[1].first && c == ac[1].second) {
                current[br][bc] = 0
                break
            }
            current[br][bc] = current[r][c]
            br = r
            bc = c
        }
    }
    var sum = 2
    for(r in current) sum += r.sum()
    println(sum)
}
