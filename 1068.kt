import java.io.*

fun main() {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var cards = br.readLine().split(" ").map {it.toInt()}

    val m = br.readLine().toInt()
    val c = br.readLine().split(" ").map {it.toInt()}

    cards = cards.sorted()

    for(i in 0 until m) {
        if(cards.binarySearch(c[i]) < 0)
            bw.write("0 ")
        else
            bw.write("1 ")
    }



    bw.write("\n")

    bw.flush()
}

