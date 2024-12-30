import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (R, C) = br.readLine().split(" ").map {it.toInt()}
    val arr = Array(R) {ArrayList<Char>()}
    var result = 0
    val route = HashSet<Char>()
    repeat(R){
        arr[it].addAll(br.readLine().map {it})
    }
    fun find(x: Int, y: Int, weight: Int){
        route.add(arr[x][y])
        if(result < weight) result = weight
        if(x<R-1 && !route.contains(arr[x+1][y]))
            find(x+1, y, weight+1)
        if(y<C-1 && !route.contains(arr[x][y+1]))
            find(x, y+1, weight+1)
        if(x>0 && !route.contains(arr[x-1][y]))
            find(x-1, y, weight+1)
        if(y>0 && !route.contains(arr[x][y-1]))
            find(x, y-1, weight+1)
        route.remove(arr[x][y])
    }

    find(0,0,1)
    bw.write("$result")
    bw.flush()
    bw.close()
}
