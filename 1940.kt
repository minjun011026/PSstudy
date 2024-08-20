import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val materials = br.readLine().split(" ").map {it.toInt()}
    val sortedMaterials = materials.sorted().filter { it < m }
    var cnt = 0
    var i = 0
    var j = sortedMaterials.lastIndex
    while(i < j) {
        if(sortedMaterials[i]+sortedMaterials[j] == m) {
            cnt++
            i++
            j--
        }
        else if(sortedMaterials[i]+sortedMaterials[j] < m) i++
        else j--
    }
    bw.write("$cnt")
    bw.flush()
    bw.close()
}
