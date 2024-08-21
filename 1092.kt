import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val crain = ArrayList<Int>()
    val item = ArrayList<Int>()
    var time = 0

    crain.addAll(br.readLine().split(" ").map {it.toInt()})

    val m = br.readLine().toInt()

    item.addAll(br.readLine().split(" ").map {it.toInt()})

    crain.sortDescending()
    item.sortDescending()

    if(item[0]>crain[0]){
        bw.write("-1")
    }else {
        while (item.isNotEmpty()) {
            var crainIdx = 0
            var itemIdx = 0
            while (crainIdx < crain.size) {
                if (itemIdx == item.size) break
                if (crain[crainIdx] >= item[itemIdx]) {
                    item.removeAt(itemIdx)
                    crainIdx++
                } else
                    itemIdx++
            }
            time++
        }
        bw.write("$time")
    }
    bw.flush()
    bw.close()
}
