fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        val num = readln().split(" ").map { it.toInt() }
        val target = readln().toInt()
        val arr = Array(n) { Array(target+1) { 0 } }

        for(i in 0..< n) {
            if(num[i] <= target) arr[i][num[i]] = 1
        }

        for(i in 0..< n) {
            for(j in 1..target) {
                if(i>0) arr[i][j] += arr[i-1][j]
                if(j-num[i] > 0) arr[i][j] += arr[i][j-num[i]]
            }
        }

        println("${arr[n-1][target]}")
    }
}
