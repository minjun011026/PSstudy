import java.io.*
import java.util.Collections
import java.util.PriorityQueue

data class Jewelry(
    val weight: Int,
    val value: Int
) : Comparable<Jewelry> {
    override fun compareTo(other: Jewelry): Int {
        return if (this.weight != other.weight) weight - other.weight
        else other.value - value
    }
}

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var sum = 0L
    val jewel = PriorityQueue<Jewelry>()
    val bags = ArrayList<Int>()

    repeat(n) {
        val (w, p) = br.readLine().split(" ").map { it.toInt() }
        jewel.add(Jewelry(w,p))
    }

    repeat(k) {
        bags.add(br.readLine().toInt())
    }


    bags.sort()

    bags.forEach { weight ->
        while (jewel.isNotEmpty()) {
            if(jewel.peek().weight <= weight)
                pq.add(jewel.poll().value)
            else break
        }

        if (pq.isNotEmpty()) sum += pq.poll()
    }

    bw.write("$sum")
    bw.flush()
    bw.close()
}
